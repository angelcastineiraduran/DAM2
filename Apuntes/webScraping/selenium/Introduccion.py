import time
from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
driver.get("https://www.selenium.dev/selenium/web/web-form.html")

# peticion al navegador
title = driver.title

# sincronizar el codigo con el estado actual del navegador = MUY dificil
# basicamente deseamos que el elemento a buscar este en la pag antes de buscarlo nosotros
# y ademas este en un estado interactivo antes de intentar interactuar con el.
# una espera implicita no es la mejor solucion pero si es la mas facil por lo que la
# vamos a usar como marcador de posicion
driver.implicitly_wait(0.5)

# finding an element
text_box = driver.find_element(by=By.NAME, value="my-text")
submit_button = driver.find_element(by=By.CSS_SELECTOR, value="button")

# take action on element
text_box.send_keys("Selenium")
submit_button.click()

# peticion de info de un elemento
message = driver.find_element(by=By.ID, value="message")
text = message.text

driver.quit()
