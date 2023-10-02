# gen by chatGPT

import os
import argparse

# Create an argument parser
parser = argparse.ArgumentParser(description="Create a set of files by name in a specified directory with a given file extension, replacing spaces with underscores.")

# Add a command-line argument for the directory
parser.add_argument("directory", type=str, help="Directory where files will be created")

# Add a command-line argument for the text file containing file names
parser.add_argument("file_list", type=str, help="Text file containing file names")

# Add a command-line argument for the file extension
parser.add_argument("file_extension", type=str, help="File extension for the created files")

# Parse the command-line arguments
args = parser.parse_args()

# Create the directory if it doesn't exist
if not os.path.exists(args.directory):
    os.makedirs(args.directory)

# Read file names from the specified text file and replace spaces with underscores
with open(args.file_list, 'r') as file:
    file_names = [line.strip().replace(" ", "_") for line in file]

# Create empty files with the specified names and extension in the directory
for file_name in file_names:
    file_name_with_extension = f"{file_name}.{args.file_extension}"
    file_path = os.path.join(args.directory, file_name_with_extension)
    with open(file_path, 'w') as file:
        pass  # Create an empty file

print(f"{len(file_names)} files created in {args.directory} with the extension .{args.file_extension}")
