import zipfile
import os
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By

# poner el archivo del chrome driver en el directorio
# en el que estoy trabajando
driver = webdriver.Chrome()
driver.get("https://eportal.mapa.gob.es/websiar/SeleccionParametrosMap.aspx?dst=1")
