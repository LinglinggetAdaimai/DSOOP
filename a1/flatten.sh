# get every c file frm the dir + its subdur as well.
# put it in the same folder and zip it >> handin.zip

#!/bin/bash

# Instruction
# put every .c file in current dir in a file and zip it.
# after everything is done give back the filename that has code in it + .zip filename


# my logic
# copy every .c file to one folder
# zip it, delete the folder that we used to store the c file



# make a folder for putting the file in
foldername=$( echo $1 | sed -e 's/\.\/\(.*\)\.zip/\1/' )
mkdir $foldername
echo "makedir already"

# copy all of the c file in to folder 
find . -name '*.java' -exec cp {} $foldername/ \; 
echo "copy everything alr"
echo $foldername

# zip it -> delete the new folder recursively
zip -r $foldername.zip $foldername
rm -r $foldername


