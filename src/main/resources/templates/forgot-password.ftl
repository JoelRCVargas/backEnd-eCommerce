<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>A Simple Responsive HTML Email</title>
        <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@600&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300&family=Raleway:wght@600&display=swap" 
        rel="stylesheet">
        <style type="text/css">
	        .body {
			    margin: 0; 
			    padding: 0; 
			    min-width: 100%;
			    font-family: 'Lato', sans-serif;
			    
			}
			a{
			    text-decoration: inherit;
			    color: #FFF;
			    display: block;
			    padding: 25px;
			}
			.container {
			    margin: auto;
			    display: table;
			    text-align: center;
			    flex-wrap: wrap;
			    width: 100vh; 
			    height: 100%;
			    background: #FFF;
			    color: #707070;
			    max-width: 520px;
			}  
			.container .logo{
			    font-family: 'Raleway', sans-serif;
			    font-size: 50px;
			    color: #6600ff;
			}
			.container .sub-title{
			    font-size: 22px;
			    font-weight: 600;
			}
			.container .title{
			    font-family: 'Raleway', sans-serif;
			    color: #000 !important;
			    font-weight: bold;
			    font-size: 26px;
			    text-transform: uppercase;
			}
			.container .btn{
			    background: #6600ff;
			    border-radius: 6px;
			    text-transform: uppercase;
			    font-weight: 600;
			    padding: 10px 50px;
			    font-size: 20px;
			    width: 100%;
			    max-width: 230px;
			    color: #FFF;
			    margin-top: 25px;
			    margin-button: 25px;
			}
			.container .btn.btn-primary:hover{
			    opacity: .7;
			}
			.container .btn-enlace{
			    color: #6600ff;
			    text-decoration: underline;
			    text-transform: inherit;
			}
			.container .email{
				background: #6600ff;
				padding: 10px;
				color: #FFF;
			}
        </style>
    </head>
    <body class="body">
        <div class="container">
            <h1 class="logo">LOGO</h1>
            <p class="sub-title">¡Hola! ${NAME_USER}.</p>
            <h1 class="title">Recupera tu contraseña</h1>
            <p>Si recibes este mensaje es porque solicitaste recuperar tu contraseña y puedes hacerlo dándole clic al botón de abajo</p>
            <a href="${VERIFICATION_URL}"><span  class="btn">Confirmar</span></a>
            <p>Si no realizaste esta acción, omite este mensaje.</p>
            <p>Si tienes problemas con el botón de arriba, ve al siguiente enlace:</p>
            <a href="${VERIFICATION_URL}"><span class="btn-enlace">${VERIFICATION_URL}</span></a>
            <h1 class="title">¿Necesitas ayuda?</h1>
            <p>Por favor envianos tus dudas o sugerencias a : </p>
            <span class="btn-enlace">infobeecompany@gmail.com.</span>
        </div>
    </body>
</html>