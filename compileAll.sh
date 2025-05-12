#!/bin/sh

for name in $(cat ./to_compile_by_order.txt);
do
	javac -cp bin/ -d bin/ Ech3c_Java/$name.java
done
