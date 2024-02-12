# instalar Beautifulsoup, ir docu oficial
import urllib.request
from bs4 import BeautifulSoup

html = urllib.request.urlopen('https://openwebinars.net/')
# creo obj BeautifulSoup
soup = BeautifulSoup(html, 'html.parser')
# imprime todo
#print(soup.prettify())
print(soup.h5) # > <h5 class="submenu__categories--title">Cursos de Innovación Digital y Tecnología</h5>
print(soup.h5.name) # > h5
print(soup.h5.string) # > Cursos de Innovación Digital y Tecnología
print(soup.h5.parent.name) # > div
print(soup.h5['class']) # > ['submenu__categories--title']
print(soup.find_all('h5')) # encuentra todos los h5
print(soup.find(id="vwoCode")) # encuentra la etiqueta con ese id

# itero sobre todos los ele encontrados en el objeto `soup`
# continuar mas tarde...
for ele in soup.find_all('link'):
    print(ele.get('href'))