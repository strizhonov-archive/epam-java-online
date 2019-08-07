TASK: 
Дана строка, содержащая следующий текст (xml-документ):
<pre><code>
&lt;notes>
   &lt;note id = "1"&gt;
       &lt;to&gt;Вася&lt;/to&gt;
       &lt;from&gt;Света&lt;/from&gt;
       &lt;heading&gt;Напоминание&lt;/heading&gt;
       &lt;body&gt;Позвони мне завтра!&lt;/body&gt;
   &lt;/note&gt;
   &lt;note id = "2"&gt;
       &lt;to&gt;Петя&lt;/to&gt;
       &lt;from&gt;Маша&lt;/from&gt;
       &lt;heading&gt;Важное напоминание&lt;/heading&gt;
       &lt;body/&gt;
   &lt;/note&gt;
&lt;/notes&gt;
</code></pre>
Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
нельзя.