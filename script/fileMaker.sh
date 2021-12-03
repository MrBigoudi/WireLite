#!/bin/bash

[ ! -f $1 ] && echo "Error arguments ${1} is not a file" && exit 1

hexa=a-fA-F\d
#cat $1 | sed -E "s/^([${hexa}]* ([${hexa}]{2} )*([${hexa}]{2}+)).*$/\1/"

cat $1 | sed -E 's/^([a-f\d]*\ ([a-f\d]{2}\ )*([a-f\d]{2}+)).*$/\1/'
