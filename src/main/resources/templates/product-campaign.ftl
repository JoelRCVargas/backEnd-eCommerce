<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>A Simple Responsive HTML Email</title>
        <style type="text/css">
        	.container{
			    max-width: 600px;
			    margin: auto;
			    font-family: 'Raleway', sans-serif !important;
			    text-align: center;
			    background-color: #f5f5f5;
			    padding-bottom: 20px;
			}
			.container .logo{
			    font-size: 30px;
			    color: #6600ff;
			    text-align: center;
			    padding: 20px 0;
			    padding-bottom: 0;
			}
			.container .sub-title{
			    font-size: 17px;
			    font-weight: 600;
			    text-align: center
			}
			.container .title{
			    color: #000 !important;
			    font-weight: bold;
			    font-size: 26px;
			    text-transform: uppercase;
			}
			.container img{
			    padding: 20px 0;
			    width: 60%;
			    min-width: 400px;
			}
			
			.container .btn-product{
			    color: #FFF;
			    background-color: #6600ff;
			    margin: auto;
			    border: none;
			    padding: 10px;
			    font-size: 18px;
			    width: 50%;
			    display: table;
			    border-radius: 5px;
			    text-transform: uppercase;
			    text-decoration: none;
			}
			
			.container .btn-product svg{
			    width: 25px;
			    height: 25px;
			    margin-bottom: -5px;
			    padding-top: 2px;
			    margin-right: 5px;
			}
			
			.container .btn-enlace{
			        color: #6600ff;
			}
			</style>
        <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@600&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300&family=Raleway:wght@600&display=swap" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1 class="logo">BEESTORE</h1>
            <p class="sub-title">No puedes dejar pasar está oportunidad unica.</p>
            <h1 class="title">PRODUCT NAME</h1>
            <img src="http://images.nike.com/is/image/DotCom/PDP_HERO_S/NIKE-YA-LEBRON-MAX-AIR-BP-BA5124_010_A.jpg" alt="">
            <a href="http://localhost:4200/product/details/6c77d92b-0f2e-429c-9aac-0b491370b1b0" class="btn-product"> 
                VER PRODUCTO EN TIENDA
            </a>
            <h1 class="title">¿Necesitas ayuda?</h1>
            <p>Por favor envianos tus dudas o sugerencias a</p>
            <span href="" class="btn btn-enlace">infobeecompany@gmail.com</span>
        </div>
    </body>
</html>