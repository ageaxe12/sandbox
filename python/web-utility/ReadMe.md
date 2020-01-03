# Command to be run 
* docker-compose run web django-admin startproject webutility .
    cd webutility
    python manage.py startapp headerutil
    python manage.py startapp vault
    docker-compose --verbose up --build
    python manage.py makemigrations
    python manage.py migrate 