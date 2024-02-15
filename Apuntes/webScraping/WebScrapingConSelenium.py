import time


from selenium.webdriver.common.by import By

from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.select import Select

# necesitamos emular a una persona para que rellene el formulario
driver = webdriver.Chrome()
driver.get("https://eportal.mapa.gob.es/websiar/SeleccionParametrosMap.aspx?dst=1")
driver.implicitly_wait(0.5)

# seleccionamos en el selector la opcion de Aragón
desplegable_comunidad = driver.find_element(By.NAME, 'ctl00$ContentPlaceHolder1$DropDownListCCAA')
select = Select(desplegable_comunidad)
select.select_by_value("8")

# para comportarme como un humano
time.sleep(1)

# seleccionamos zaragoza
desplegable_provincia = driver.find_element(By.NAME, 'ctl00$ContentPlaceHolder1$DropDownListProvincia')
select = Select(desplegable_provincia)
select.select_by_value("50")

time.sleep(2)
# lo hago con la estacion que me aparece por defecto para no enrollarme
seleccionar_estacion = driver.find_element(By.NAME, 'ctl00$ContentPlaceHolder1$ButtonAgregar').click()

time.sleep(1)
consultar_datos = driver.find_element(By.ID, 'ContentPlaceHolder1_btnConsultar').click()

# paso a la otra ventana que se genera 
time.sleep(2)
driver.switch_to.window(driver.window_handles[1])
print("paso a la ventana 2")
time.sleep(2)
exportar_csv_link = driver.find_element(By.ID, 'ContentPlaceHolder1_ExportarCSV')
descargar_csv = exportar_csv_link.click()
print("csv descargado")
time.sleep(4)

driver.quit()