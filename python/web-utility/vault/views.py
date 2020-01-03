from django.shortcuts import render
# Create your views here.
from django.http import JsonResponse, HttpRequest
from rest_framework.utils import json
from .models import DictEntry
from rest_framework.decorators import api_view
import logging
from django.views.decorators.csrf import csrf_exempt
from django.core import serializers
from django.forms.models import model_to_dict
import json

# Get an instance of a logger
logger = logging.getLogger("django")


@csrf_exempt
def home(request):
    """
    :type request: HttpRequest
    """
    if request.method == 'GET':
        # TODO Add condition to get Specific object
        return getall(request)
    if request.method == 'POST':
        return save(request)
    if request.method == 'DELETE':
        return delete(request)


def getall(request):
    logger.info('Received GET ALL request on VAULT')
    all_entities = DictEntry.objects.all()

    return JsonResponse(serializers.serialize('json', all_entities), safe=False)


def save(request):
    received_json_data = json.loads(request.body)

    logger.info('Received POST request on Vault /n {}'.format(received_json_data))
    """

    :type received_json_data: dictionaries 
    """
    logger.info('Received POST request on Vault /n Key = {}, Value = {} '.format(str(received_json_data.keys()),
                                                                                 str(received_json_data.values())))

    b = DictEntry(key=received_json_data.get("key"), value=received_json_data.get("value"))
    b.save()

    logger.info('Saved Entity {}'.format(b))
    return JsonResponse({"models_to_return": b.id}, safe=False)
    # return JsonResponse({"models_to_return": b.}, safe=False)


@csrf_exempt
def getbyid(req_id):
    """
    :type request: HttpRequest
    """
    logger.info('Received DELETE request on VAULT for ID {}'.format(req_id))
    dict_entry = DictEntry.objects.get(id=req_id)
    return JsonResponse(serializers.serialize('json', dict_entry), safe=False)


def delete(request):
    """
    :type request: HttpRequest
    """
    logger.info('Received DELETE request on VAULT for ID {}'.format(request.path_info))
    dict_entry = DictEntry.objects.get(id=1)
    return JsonResponse(serializers.serialize('json', dict_entry), safe=False)
