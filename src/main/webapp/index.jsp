<html>
<head>
<style>
      .transparent {
         position: relative;
         max-width: 400px;
         padding: 60px 50px;
         margin: 50px auto 0;
         background:cadetBlue;
	 background-size: cover;
      }

      .transparent:before {
         content: "";
         position: absolute;
         top: 0;
         left: 0;
         right: 0;
         bottom: 0;
	 
         }

      .form-inner {
         position: relative;
      }

      .form-inner h3 {
         position: relative;
         margin-top: 0;
         color: white;
         font-family: 'Roboto', sans-serif;
         font-weight: 300;
         font-size: 26px;
         text-transform: uppercase;
      }

      .form-inner h3:after {
         content: "";
         position: absolute;
         left: 0;
         bottom: -6px;
         height: 2px;
         width: 60px;
         background: white;
      }

      .form-inner label {
         display: black;
         padding-left: 15px;
         font-family: 'Roboto', sans-serif;
         color: rgba(255, 255, 255, .6);
         text-transform: uppercase;
         font-size: 14px;
      }

      .form-inner input {
         display: block;
         width: 100%;
         padding: 0 15px;
         margin: 10px 0 15px;
         border-width: 0;
         line-height: 40px;
         border-radius: 20px;
         color: white;
         background: rgba(255, 255, 255, .3);
         font-family: 'Roboto', sans-serif;
      }

      
     
      .form-inner input[type="submit"] {
         background: rgba(245, 222, 179);
      	color: rgba(43, 44, 78, .5);
      
	 font-family: 'Roboto', sans-serif;
         font-weight: 300;
         font-size: 26px;
         text-transform: uppercase;
	 
      }

      @media(max-width:480px) {
         .transparent {
            padding: 30px 20px;
         }
      }
   </style>
</head>

<body>
<form class="transparent">
         <div class="form-inner">
            <h3>Авторизация</h3>
            <label for="username">Имя пользователя</label>
            <input type="text" id="username">
            <label for="password">Пароль</label>
            <input id="password" type="password">
            <input type="submit" value="Отправить">
         </div>
      </form>
</body>
</html>
