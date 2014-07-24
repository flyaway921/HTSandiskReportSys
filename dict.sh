#!/bin/bash
#利用网易字典查询单词含义查询单词含义
curl http://dict.youdao.com/search?q=$1 --silent|\
awk 'NR==90,NR==120' |\
tr -d '\n '|\
sed 's:<\/li>:\n:g' |\
sed '/.*<li>\(.*\)/!d'|\
sed 's/.*<li>\(.*\).*/\n\1/g'
#echo "\r"
