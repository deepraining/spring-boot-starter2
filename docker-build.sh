#!/bin/bash

# 构建并本地运行(以pro-front项目为例)

#set -e

project_name='pro-front'
app_name='sbs-front'
group_name='deepraining'
server_env='prod'

# 最多保存版本数
max_versions=3

# 构建Java项目
rm -rf $project_name/build/libs/*
rm -rf $project_name/build/distributions/*
./gradlew $project_name:build

app_version=$(ls $project_name/build/libs | sed "s/.*${app_name}-//" | sed 's/.jar$//')

echo "$app_name version: $app_version"

# 构建docker镜像
docker build --build-arg JAR_FILE=$project_name/build/libs/$app_name-$app_version.jar -t $group_name/$app_name:$app_version .

# 删除多余的镜像
# 当前存在的版本
existed_versions=$(docker images $group_name/$app_name | grep "$group_name/$app_name" | wc -l)

if [ $existed_versions -gt $max_versions ]; then
  # 删除多余的版本
  overflow_versions=$((existed_versions - max_versions))
  delete_versions=$(docker images $group_name/$app_name | grep "$group_name/$app_name" | tail -$overflow_versions | awk '{print $2}')
  echo "最多保留${max_versions}个版本数据，删除以下多余的版本数据"
  echo $delete_versions

  for delete_version in $delete_versions
  do
    docker rmi $group_name/$app_name:$delete_version
  done
fi

# 更新正在运行的镜像
running_app=$(docker ps -a  --format "{{.Names}}" | grep "$app_name")
if [ ! -z "${running_app}" ]; then
  docker stop $app_name
  docker rm $app_name
fi

docker run --restart=always -p 18001:18001 --name $app_name \
-e SERVER_ENV=$server_env \
-v /data/app/$app_name/logs:/var/logs \
-d $group_name/$app_name:$app_version

echo "$app_name:$app_version is running now"
