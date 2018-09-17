# CSS

* 동일한 속성의 값을 여러번 수정하면 마지막에 입력한 값으로 적용된다.
* 아래 예에서는 속성1은 속성값1-2로 적용

```
셀렉터 {
    속성1 : 속성값1-1;
    속성2 : 속성값2;
    속성3 : 속성값3;
    속성1 : 속성값1-2;
}
```

## 셀렉터

* 태그

  ```css
  태그 {
      속성1 : 속성값1;
  }
  div{
      width : 50%;
  }
  ```

* 클래스

  ```css
  .클래스 {
      속성1 : 속성값1;
  }
  .container{
      width : 750px;
  }
  ```

* 아이디

  ```css
  #아이디 {
      속성1 : 속성값1;
  }
  #id{
      width : 100%;
  }
  ```

* 가상클래스

  ```css
  셀렉터:가상클레스{
      속성1 : 속성값1;
  }
  /* a태그에 마우스를 겹치면 */
  a:hover{
      text-decoration : none; /* 밑줄 제거 */
  }
  ```

# CSS 종류

* font-weight

  * 글자의 굵기를 조절
  * 100~900 사이의 값을 가질 수 있음
  * bold : 700

* font-size

  * 글자의 크기를 조절

* color

  * 글자의 색을 조절

  * 값으로 지정된 색상 이름을 사용 가능

    ```css
    color : red;
    ```

  * 색상 코드를 이용하여 사용 가능 

    ```css
    color : #ff0000;/*#ABCDEF에서 AB는 Red, CD는 Green, EF는 Blue의 값을 16진수로 표현*/
    ```

  * rgb함수를 이용하여 사용 가능

    ```css
    color : rgb(255,0,0);
    ```

  * rgba함수를 이용하여 사용 가능

    ```css
    color rgba(255,0,0,1);
    ```

* text-align

  * 글자 정렬
  * center : 가운데 정렬, left : 좌측 정렬, right : 우측정렬

* display

```css

```

* width : 가로의 길이
* 











