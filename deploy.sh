#!/bin/sh

COMMIT_MSG="Deploying site $(date +%Y-%m-%d:%H:%M:%S)"
echo $COMMIT_MSG

if [[ $(git status -s) ]]
then
    echo "The working directory is dirty. Please commit any pending changes."
    exit 1;
fi

echo "Deleting old version..."
rm -rf public/*

echo "Building new version..."
hugo

cd public
git add *
git commit -m "$COMMIT_MSG"
git push origin master
cd ..


