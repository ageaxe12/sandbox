from django.db import models

# Create your models here.
from django.db import models


class DictEntry(models.Model):
    id = models.AutoField(primary_key=True)
    key = models.CharField(max_length=30)
    value = models.CharField(max_length=50)
