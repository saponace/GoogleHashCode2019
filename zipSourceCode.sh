#!/usr/bin/env bash
#removes an existing archive
rm googleHashCode2019.*
#zip all the project code
zip -r googleHashCode2019 . -x *.git/* -x *inputDataSets/*
