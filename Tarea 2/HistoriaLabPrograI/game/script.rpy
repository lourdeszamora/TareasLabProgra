# You can place the script of your game in this file.
# - Puedes colocar el 'script' de tu juego en este archivo.

# Declare images below this line, using the image statement.
# - Declara imágenes bajo esta línea, usando 'image' como
#   en el ejemplo.
# eg. image eileen happy = "eileen_happy.png"

# Declare characters used by this game.
# - Declara los personajes usados en el juego como en el 
#   ejemplo.
define d = Character('Dipper', color="#c8ffc8")
image logodec="images/logo.png"
image fondo1="images/fondo1.jpg"

image dipperfeliz = im.Scale("images/dipperfeliz.png", 300, 500)
image dipper leyendo=im.Scale("images/dipperleyendo.png", 300, 500)
image dipper incredulo=im.Scale("images/dipperincredulo.png", 300, 500)

# The game starts here.
# - El juego comienza aquí.
label start:

    scene fondo1
    show dipperfeliz at truecenter
    d "Recuerdas las series que veias de pequeño?"
    
    menu:
        "Si los recuerdo":
            jump contI
        "No los recuerdo":
            jump salir1
        "Un poco":
            jump contII
label contI:
    d "De acuerdo juguemos algo"
    jump pregunta1
label contII:
    d "Intentemos un juego"
    jump pregunta1
label salir1:
    d "Lo siento asi no podemos jugar"
    return
    

label pregunta1:
    hide dipperfeliz
    show dipper leyendo at left
    d "vamos a hacer una pequeña prueba"
    d "¿Como se llama el dueño de coraje(el perro cobarde)?"
    menu:
        "Hugo":
            jump incorrecto
        "Marcos":
            jump incorrecto
        "Justo":
            jump correcto
        "Maria":
            jump incorrecto
        d "Seguro ok. Miremos la respuesta"
label videocoraje:
    $ renpy.movie_cutscene("coraje.avi")
    jump pregunta2
label incorrecto:
    hide dipper leyendo
    show dipper incredulo at truecenter
    d "Creia que enserio sabias la respuesta"
    d "Miremos la respuesta correcta"
    jump videocoraje
label correcto:
    hide dipper leyendo
    show dipperfeliz at truecenter
    with fade 
    
    d "Muy Bien Tenias Razon"
    jump videocoraje
    
label pregunta2:
    d "Ya no hay mas preguntas"
return