# HTML이란?

* HTML은 하이퍼텍스트 마크업 언어(HyperText Markup Language)라는 의미의 웹 페이지를 위한 지배적인 마크업 언어
* 웹 페이지 콘텐츠 안의 꺾쇠 괄호에 둘러싸인 "태그"로 되어있는 HTML 요소 형태로 작성

# 태그란?

* HTML를 구성하기 위한 요소
* 꺽쇠 괄호에 둘러 쌓여 있음 : <태그명>

# 태그의 분류

* Block 태그 
  * Block 태그는 새로운 라인에서 시작 되며, Block 태그 다음에 오는 모든 태그들은 새 라인에서 시작  >> 행렬로 비교하면 행에 해당
  * Block 태그들은 css의 속성 중 height, width, margin, padding을 적용할 수 있다.
  * 예 : `<p>` ,`<div>`
* Inline 태그
  * Inline 태그들은 새라인에서 시작하지 않고 현재 라인에서 시작 >> 행렬로 비교하면 열에 해당
  * Inline 태그들은 css의 속성 중 height, width, margin, padding등의 속성을 적용할 수 없다.
  * 예 : `<span>`
* 쌍으로 된 태그
  * 태그의 시작과 끝이 따로 있어 시작과 끝 사이에 안에 코드를 넣는 태그 : <태그> 코드 </태그>
  * 예 : `<p>` ,`<div>` 등.. 
* 쌍이 아닌 태그
  * 태그의 시작과 끝이 따로 없는 태그 : <태그/> 또는 <태그>
  * 예 : `<br>`, `<input>` 등..

# 태그 종류

* ### HTML태그 : `<html>`

  * HTML로 작성되어 있다는 것을 알려줌.

  * html 파일 전체를 감싸는 태그

    ```html
    <html>
        <head>
            <meta>
            <link>
            <script></script>
        </head>
        <body>
        </body>
    </html>
    ```

* #### HEAD 태그 : `<head>`

  * 머리말에 해당함.
  * css나 javascript를 연결해줌.
  * 파비콘이나 문자열 인코딩과 같은 문서의 다양한 정보를 제공.

  ```html
  <head>
      <meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
      <title>타이틀</title>
      <link rel="stylesheet" 
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
          crossorigin="anonymous">
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
          integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
          crossorigin="anonymous"></script>
  	<script 
          src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" 
          integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" 
          crossorigin="anonymous"></script>
  	<script 
          src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
          integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" 
          crossorigin="anonymous"></script>
  </head>
  ```

* META 태그 : `<meta>`

  * 문서의 문자열 인코딩 등과 같은 문서의 다양한 정보를 제공.

* TITLE 태그 : `<title>`

  * 타이틀바에 입력될 텍스트

* LINK 태그 : `<link>`

  * 주로 외부 css 파일을 연결할 때 사용

* SCRIPT 태그 : `<script>` 

  * 외부 js 파일을 연결하거나 javascript 코드를 입력할 때 사용

* #### BODY 태그 : `<body>`

  * 본문에 해당하는 부분
  * 실제 보여지는 화면에 해당

* P 태그 : `<p>`

  * 단락을 나눌 때 사용
  * HTML에서는 엔터를 쳐서 여러 문장을 입력하더라도 줄바꿈이 적용되지 않음
  * P태그 안에서는 하나의 문장이 되고 P태그가 종료되면 단락이 된다.

* BR 태그 : `<br>`

  * 줄바꿈

* B 태그 : `<b>`

  * Bold = 굵은 글씨

* I 태그 : `<i>`

  * 이탤릭체 글씨 = 기울어진 글씨
  * 아이콘 : fontawesome을 이용하여 아이콘을 표시할 때 사용

* H 태그 : `<h1>`, `<h2>`, `<h3>`, `<h4>`, `<h5>`, `<h6>`

  * 제목에 해당
  * 숫자가 낮을수록 글씨가 큼

  ```html
  <h1>h1 : 블락태그 - 제목</h1>
  <p>p : 블락태그 - 문장</p>
  br : 줄바꿈<br>
  <b>b : 인라인 태그 - 굵은 글씨</b><br>
  <i>i : 인라인 태그 - 기울기 글씨</i><br>
  hr : 블락 태그 - 밑줄<hr>
  ```

* HR 태그 : `<hr>`

  * 직선을 그림

* DIV 태그 : `<div>`

  * 상자를 만듬

    ```html
    <div>div : 블락 태그 </div>
    ```

* SPAN 태그 : `<sapn>`

  * 요소 일부만 디자인이나 기능을 변경할 때 사용

* IMG 태그 : `<img>`

  * 이미지를 가져옴

  * src 속성 : 가져올 이미지의 주소

  * alt 속성 : 이미지 불러오기 실패시 보여줄 문자열

  * width 속성 : 이미지의 가로의 길이

  * height 속성 : 이미지의 세로의 길이

    ```html
    <img src="data:image/jpeg;base64,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" 
    	alt="고양이" width="100px" height="auto">
    ```

* INPUT 태그 : `<input>`

  * 입력창을 만드는 태그
  * 속성 type에 따라 다양한 속성을 가진 입력창을 생성
    * text : 텍스트를 입력할 수 있는 입력창
    * password : 비밀번호를 입력할 수 있는 입력창
    * checkbox : 체크 박스를 만듦
    * radio : 라디오 박스를 만듬
    * button : 버튼을 만듬
    * submit : 데이터 전송 버튼을 만듬
    * reset : 초기화 하는 버튼을 만듬
    * file : 파일을 선택하는 창을 만듬
    * hidden : 사용자에게 보이지 않는 창을 만듬
    * email : email 형식의 주소를 입력하는 창을 만듬
    * url : url 형식의 주소를 입력하는 창을 만듬
    * 등이 있음

    ```html
    <input type="text" name="" id="" placeholder="input : text">
    <br>
    <input type="checkbox"> 짜장면
    <input type="checkbox"> 짬뽕
    <br>
    <input type="radio" name="gender" checked> 남자
    <input type="radio" name="gender"> 여자
    <br>
    <input type="password" placeholder="input:passwoard"> 비밀번호
    <br>
    <input type="button" value="input:button">
    <br>
    <input type="file">
    <br>
    <input type="email" placeholder="input:email">
    ```

* BUTTON 태그 : `<button>`

  * 버튼을 생성하는 태그
  * 속성 type에 따라 다양한 속성을 가진 버튼을 생성
    * button : 버튼을 생성
    * reset : 초기화
    * submit : 데이터를 전송하는 버튼으로 form태그와 같이 사용

    ```html
    <button>button: 인라인태그 - 버튼 </button>
    ```

* FORM 태그 : `<form>`

  * 데이터를 전송하기 위한 태그
  * action 속성 : 데이터를 전송할 url
  * method 속성 : 데이터 전달 방식이 get인지 post인지 결정

* A 태그 : `<a>`

  * 클릭시 다른 주소로 이동하는 태그

  * href : 넘어갈 주소

    ```html
    <a href="http://www.naver.com">네이버</a>
    ```

* UL 태그 : `<ul>`

  * 번호가 없는 리스트
  * LIST 태그를 이용

* OL 태그 : `<ol>`

  * 번호가 있는 리스트
  * LIST 태그를 이용

* LI 태그 : `<li>`

  * UL태그나 OL 태그안에서 사용되는 태그

    ```html
    과일
    <ol>
        <li>사과</li>
        <li>포도</li>
        <li>오렌지</li>
    </ol>
    과일
    <ul>
        <li>사과</li>
        <li>포도</li>
        <li>오렌지</li>
    </ul>
    ```

* SELECT 태그 : `<select>`

  * 셀렉트 박스 창을 만드는 태그

  * OPTION태그를 이용하여 여러 내용을 입력

    ```html
    <select>
        <option value="전체">전체</option>
        <option value="제목">제목</option>
        <option value="내용">내용</option>
    </select>
    ```

  