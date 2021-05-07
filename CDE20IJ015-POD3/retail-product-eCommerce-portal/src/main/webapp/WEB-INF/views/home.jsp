<!DOCTYPE html>
<html>

<head>
    <title>Shopping</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,800">

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            background: #f6f5f7;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            font-family: 'Montserrat', sans-serif;
            height: 90vh;
            margin: -20px 0 50px;
        }

        h1 {
            font-weight: bold;
            margin: 0;
        }

        p {
            font-size: 14px;
            font-weight: 100;
            line-height: 20px;
            letter-spacing: 0.5px;
            margin: 20px 0 30px;
        }

        button {
            border-radius: 20px;
            border: 2px solid #0e0d14;
            background-color: #314083;
            color: #FFFFFF;
            font-size: 14px;
            font-weight: bold;
            cursor: pointer;
            padding: 12px 45px;
            letter-spacing: 1px;
        }

        button.ghost {
            background-color: transparent;
            border-color: #FFFFFF;
        }

        form {
            cursor: not-allowed;
            background-color: #FFFFFF;
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            padding: 0 50px;
            height: 100%;
            text-align: center;
        }

        .container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25),
                0 10px 10px rgba(0, 0, 0, 0.22);
            position: relative;
            overflow: hidden;
            width: 868px;
            max-width: 100%;
            min-height: 530px;
        }

        .left-container {
            position: absolute;
            top: 0;
            height: 100%;
            transition: all 0.6s ease-in-out;
        }

        .sign-in-container {
            left: 0;
            width: 50%;
        }


        .right-container {
            position: absolute;
            top: 0;
            left: 50%;
            width: 50%;
            height: 100%;
            overflow: hidden;
            z-index: 100;
        }

        .overlay {
            background: linear-gradient(to right, #42278b, #314083);
            color: #FFFFFF;
            position: relative;
            cursor: not-allowed;
            left: -100%;
            height: 100%;
            width: 200%;
            
        }

        .overlay-panel {
            position: absolute;
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            padding: 0 40px;
            text-align: center;
            height: 100%;
            width: 50%;
        }
        
        .overlay-right {
            right: 0;
            transform: translateX(0);
        }
    </style>
</head>

<body>
    <br><br>
    <h1>
        <center>Welcome to<br>ShopOne</center>
    </h1>
    <br>
    <div class="container" id="container">
        <div class="left-container">
        </div>
        <div class="left-container sign-in-container">
            <form action="#">
                <h1>Welcome Back!</h1>
                        <p>To keep connected with us please login with your personal info</p>
                        <a href="login.html"><button type="button">Sign In</button></a>
            </form>
        </div>
        <div class="right-container">
            <div class="overlay">
                <div class="overlay-panel overlay-right">
                    <h1>Hello, Friend!</h1>
                    <p>Enter your personal details and start journey with us</p>
                    <a href="signup.html"> <button type="button" class="ghost" id="signUp">Sign Up</button></a>
                </div>
            </div>
        </div>
    </div>
</body>

</html>