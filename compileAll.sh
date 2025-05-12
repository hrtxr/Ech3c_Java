#!/bin/sh

for file in Ech3c_Java/*.java;
do
	javac -d bin/ $file
done
