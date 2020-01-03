from django.urls import path

from . import views

urlpatterns = [
    path('header/', views.printh),
    path('cookie/', views.printc),
]