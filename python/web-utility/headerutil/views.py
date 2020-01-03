from django.shortcuts import render
# Create your views here.
from django.http import JsonResponse, HttpResponse


def printh(request):
    response_data = {}
    request_data = request.META
    for key in request_data:
        response_data[key] = str(request_data[key])
    return JsonResponse(response_data)


def printc(request):
    """
    :type request: HttpResponse
    """
    return JsonResponse(request.COOKIES)
