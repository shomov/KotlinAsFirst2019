package lesson7.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.io.File

class Tests {

    private fun assertFileContent(name: String, expectedContent: String) {
        val file = File(name)
        val content = file.readLines().joinToString("\n")
        assertEquals(expectedContent, content)
    }

    @Test
    @Tag("Example")
    fun alignFile() {
        alignFile("input/align_in1.txt", 50, "temp.txt")
        assertFileContent(
            "temp.txt",
            """Для написания разных видов программ сейчас
применяются разные языки программирования.
Например, в сфере мобильных программ сейчас правят
бал языки Swift (мобильные устройства под
управлением iOS) и Java (устройства под
управлением Android). Системные программы, как
правило, пишутся на языках C или {cpp}. Эти же
языки долгое время использовались и для создания
встраиваемых программ, но в последние годы в этой
области набирает популярность язык Java. Для
написания web-клиентов часто используется
JavaScript, а в простых случаях -- язык разметки
страниц HTML. Web-серверы используют опять-таки
Java (в сложных случаях), а также Python и PHP (в
более простых). Наконец, простые desktop-программы
сейчас могут быть написаны на самых разных языках,
и выбор во многом зависит от сложности программы,
области её использования, предполагаемой
операционной системы. В первую очередь следует
назвать языки Java, {cpp}, C#, Python, Visual
Basic, Ruby, Swift.

Самым универсальным и одновременно самым
распространённым языком программирования на данный
момент следует считать язык Java. Java в широком
смысле -- не только язык, но и платформа для
выполнения программ под самыми разными
операционными системами и на разной аппаратуре.
Такая универсальность обеспечивается наличием
виртуальной машины Java -- системной программы,
интерпретирующей Java байт-код в машинные коды
конкретного компьютера или системы. Java также
включает богатейший набор библиотек для
разработки."""
        )
        File("temp.txt").delete()
    }

    @Test
    @Tag("Normal")
    fun countSubstrings() {
        assertEquals(
            mapOf("РАЗНЫЕ" to 2, "ные" to 2, "Неряшливость" to 1, "е" to 49, "эволюция" to 0),
            countSubstrings("input/substrings_in1.txt", listOf("РАЗНЫЕ", "ные", "Неряшливость", "е", "е", "эволюция"))
        )
        assertEquals(
            mapOf("Карминовый" to 2, "Некрасивый" to 2, "белоглазый" to 1),
            countSubstrings("input/substrings_in1.txt", listOf("Карминовый", "Некрасивый", "белоглазый"))
        )
        assertEquals(
            mapOf("--" to 4, "ее" to 2, "животное" to 2, "." to 2),
            countSubstrings("input/substrings_in2.txt", listOf("--", "ее", "животное", "."))
        )
    }

    @Test
    @Tag("Normal")
    fun sibilants() {
        sibilants("input/sibilants_in1.txt", "temp.txt")
        assertFileContent(
            "temp.txt",
            """/**
 * Простая
 *
 * В русском языке, как правило, после букв Ж, Ч, Ш, Щ пишется И, А, У, а не Ы, Я, Ю.
 * Во входном файле с именем inputName содержится некоторый текст.
 * Проверить текст во входном файле на соблюдение данного правила и вывести в выходной
 * файл outputName текст с исправленными ошибками.
 *
 * Регистр заменённых букв следует сохранять.
 *
 * Исключения (жУри, броШУра, параШут) в рамках данного задания обрабатывать не нужно
 *
 * жИ шИ ЖИ Ши ЖА шА Жа ша жу шу жу щу ча шу щу ща жа жи жи жу чу ча
 */
 ыжаажаж"""
        )
        File("temp.txt").delete()
    }

    @Test
    @Tag("Normal")
    fun centerFile() {
        centerFile("input/center_in1.txt", "temp.txt")
        assertFileContent(
            "temp.txt",
            """              Съешь же ещё этих мягких французских булок, да выпей чаю.
Широкая электрификация южных губерний даст мощный толчок подъёму сельского хозяйства.
                                        Тест
                                          """ +  // Avoiding trailing whitespaces problem
                    """
                                     Hello World
           Во входном файле с именем inputName содержится некоторый текст.
        Вывести его в выходной файл с именем outputName, выровняв по центру."""
        )
        File("temp.txt").delete()

    }

    @Test
    @Tag("Hard")
    fun alignFileByWidth() {
        alignFileByWidth("input/width_in1.txt", "temp.txt")
        assertFileContent(
            "temp.txt",
            """Простая

Во       входном       файле       с       именем       inputName       содержится       некоторый      текст.
Вывести   его  в  выходной  файл  с  именем  outputName,  выровняв  по  левому  и  правому  краю  относительно
самой                                              длинной                                             строки.
Выравнивание   производить,   вставляя  дополнительные  пробелы  между  словами:  равномерно  по  всей  строке

Слова     внутри     строки     отделяются     друг     от     друга     одним     или     более     пробелом.

Следующие                   правила                   должны                  быть                  выполнены:
1)     Каждая     строка     входного    и    выходного    файла    не    должна    заканчиваться    пробелом.
2) Пустые строки или строки из пробелов во входном файле должны превратиться в пустые строки в выходном файле.
3)   Число   строк   в   выходном  файле  должно  быть  равно  числу  строк  во  входном  (в  т.  ч.  пустых).

Равномерность              определяется              следующими             формальными             правилами:
1)  Число  пробелов  между  каждыми  двумя  парами  соседних  слов  не  должно  отличаться  более,  чем  на 1.
2)  Число  пробелов  между  более  левой  парой  соседних  слов  должно  быть  больше или равно числу пробелов
между                более               правой               парой               соседних               слов."""
        )
        File("temp.txt").delete()

    }

    @Test
    @Tag("Normal")
    fun top20Words() {
        assertEquals(mapOf<String, Int>(), top20Words("input/empty.txt"))
        assertEquals(mapOf(
            "привет" to 4,
            "все" to 3,
            "и" to 3,
            "прямо" to 3,
            "всё" to 2,
            "let" to 2,
            "us" to 2,
            "write" to 2,
            "some" to 2,
            "digits" to 2
        ), top20Words("input/top20.txt").filter { it.value > 1 })
        assertEquals(
            mapOf(
                "и" to 1106,
                "в" to 674,
                "не" to 411,
                "он" to 306,
                "на" to 290,
                "я" to 261,
                "с" to 260,
                "как" to 211,
                "но" to 210,
                "что" to 187,
                "все" to 131,
                "к" to 130,
                "она" to 126,
                "его" to 109,
                "за" to 105,
                "то" to 104,
                "а" to 98,
                "ее" to 95,
                "мне" to 95,
                "уж" to 95
            ), top20Words("input/onegin.txt")
        )
    }

    @Test
    @Tag("Normal")
    fun transliterate() {
        transliterate(
            "input/trans_in1.txt",
            mapOf('з' to "zz", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "yy", '!' to "!!!"),
            "temp.txt"
        )
        assertFileContent("temp.txt", "Zzdrавствуy,\nmyyr!!!")
        File("temp.txt").delete()

        transliterate(
            "input/trans_in1.txt",
            mapOf('з' to "zZ", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "YY", '!' to "!!!"),
            "temp.txt"
        )
        assertFileContent("temp.txt", "Zzdrавствуy,\nmyyr!!!")
        File("temp.txt").delete()
    }

    @Test
    @Tag("Normal")
    fun chooseLongestChaoticWord() {
        chooseLongestChaoticWord("input/chaotic_in1.txt", "temp.txt")
        assertFileContent("temp.txt", "Карминовый, Некрасивый")
        File("temp.txt").delete()
    }


    private fun checkHtmlSimpleExample() {
        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
            """
<html><body><p>tV<b>D}</b>enPg#wQ;Bd|l<b>#gHA4<s>:4\"</s>!<s>ub(</s>1s&<s>d6<i>dG</i>fyE&BAf<i></i>|\"<i>7U\"Oa</i><i>lUa</i>R-M&E</s><s>[U</s></b>(<i>KyoC^<b>Bs[VSU</b>w!Y^<s>OV<b></b><b>H</b>x%E</s>);<s>agE7</s><b>`</b>DL<b><s>xXUS</s>4+;H?{%pM</b><s>zx</s><b>z<s>z5yf^m</s>lW<s>6s</s>;<s>gA?\\</s>r6<s>fG</s>)VdU<s>.-</s>M3|Axe\\PwLw</b>,L&{JA<b>%<s></s>bb<s>l</s>iUX</b></i><i>/<s>`</s>j</i>M@Jj(?a;g\\Xyfg<s>UVnO.\"\"</s>Hg(Z-<i>T7R</i>-_\"o&<b>Shwg2rs.XUT|G\"@8mg't0<s>SAz(</s>uR&F</b>})8.[n<b>p3,\\<i>\"q6XYc[t0ya?[<s>\"Z4[wev35wj^Gs</s>%uHuJBPJnTB,\\&fY<s>1lK!</s>4<s>V!aTYe-q@T8ppcz|</s>Zu{T#OHd</i>DgNx'<i>b</i>3</b>dK)\\yvslguo]5o)%9In<s>S-m4R&+\"WW<b>M,]K`FA</b>P;d[@;fd[,25h{lE8`LA[ISChnAuW</s>=XB-ytpLR;Al_`LsV:0H7?l=\"UBR{HGaZ<b>=<s>C</s>s_<i><s>I`ZITWkUpZ</s></i>2B<s>cO?7s</s><s>kz:</s><s>+W=</s>j-C[H0;<s>W&<i>=j4</i>[</s>1M\"qfP]</b>\\sO=M<i>`:p</i><i>2?QNS<s>P4=:H!(<b>v</b>_|IW<b></b>kb=6</s>D\\l}Ac&W%\"(<b>x</b>PIpu=-<b>:Gz<s>#?</s><s>2]:</s>|U1<s>{_pD\\</s>,yV</b>A<s>=t<b>%B</b>gzrjbzqg[|ZS<b>e</b>g</s>S</i>-#zb?</p><p>=@IAzHi3AHO<s>\\</s>J<b><s>@@\"dD0</s>=)||.{<i>m</i>.J<i>ZW<s>p;Wb</s>KplF:5pQPj\"VQda<s>pte</s>WaoY</i>E^HS;gc3CU.<s></s>Nev`l}.Y\\KcFG</b>!\"{<s>YD,;RCsbPaH<b>c</b>IiYsXv</s>iEImLwzd<s>PT</s>C=<b>gE<i></i>L4F/<i>/<s></s>3Dh:<s>y</s>-?['<s></s>p|A0[<s>1!</s>}\"[Xltk;</i>hkY<s>swn</s>s<i>}&rH</i>6^<i>!<s></s><s></s>\\<s>zv}T</s>`w`A8</i></b>h!4g.jd?)&gS/<s>I<i>CO3hy<b>!N0D</b>dMsL</i></s>!HbtvURm9_ZZ^FMk4X-fQB\\sX<b>G&z;k\\r3|=W</b>{G4Sv}<b>VfG%9.';Ee;1J\\<i>o<s>%.gZ,-47f+)\"qfH</s>;WOF'<s></s>c4].Cb+n#LyqMU|z}</i>tb<i>^Y6<s>}</s>#<s>4L/+7tc'sw5?DsE#]#W}1?@@z]\"/W95jJ{E</s></i>Bk5LA0t<s>L%[U7h=a4A</s><s>{al9w'4kyqnLw'3<i>\\?!cmmbzhl.jL</i>W{</s>./RZU#Wv.;)o}y[yFhJ<s>DkgPHsT,</s>.Q`=NJ</b>jElKWa2isD?gIOd/f</p><p>wrWyV|<i>qrZP?f<s>9</s>^?<b>L</b></i>PI&t}a<i>\"</i>:Z}Mte2(ZP<b>R</b>Nv|XU@[<i>!t<s>-V</s>O(Ef<b>x</b>DY<b>}\\-p31Fu<s>yQ</s>w:.Q@</b>sfSjocn=<s><b>+?</b>;a<b>a</b></s>Ot#q#_0<s>,s)8jY</s>?icW',;wk]y0Q5<b>&cKEHZ^9a`<s>;Yi</s>ap</b>[4x;h</i>--9<i>L<b>KZ0h(<s>P</s>/8xs</b>rHrji|Nt=</i>'hu;wHLv{B3<i>Dr<b>.GBGa<s>Z)Wa</s>ku5</b>TBd{:<b><s>%}}Cq^</s><s>;hxMb</s>3\"\\W</b>Q</i>jXyGN<s>Q<b>I3<i>#qrlxn</i>vBgqlK+,#6@ctLfTh<i>J</i></b>r<b>'</b>lSi,|1[[</s>ml|@`MC?5&MTA<i>{7/o:(</i>r<i>TiC<b>!9A7)A9q=s</b>\\`<b>B</b></i>6<i>Y</i>Mno<b>&wg<i>;</i>]k%/H</b>o5(<b></b>{+<b>F<s>5<i>{/'c</i></s>a[?u(<s>3#7%</s></b>/%tu,Wn<i>y</i>=.k1.<s><i>dB_0=\"uL%\\DsoX%D.3=PU</i>UGZ]VW</s>1<i></i>4=<b>dh+kdN\"Z:</b>Ea<s>v</s>/CmOHxOZOg<s>n1Mc</s>R!F(I4<s>E?`z^S][y2<b>K1<i>&-\\gvm`qDT</i>bfF`;W_9A0={y84fQy_=)LsyaY<i>NIOb</i>\"</b>cw{7k</s>\\1F/4NQ<s><i>w<b>Qe0).=e</b></i>@=i</s>G\\{Z\"g+<i></i>-5'[0xFjvBB%##&%ek0Av&EH)-%%kV=g_7IcU.bj}(CB_<i>=N<b></b>^Vw+<b></b>Y2</i>Cow;@OFRDf5Ddz(dZ}Bt:u<s>xGC5eae&eav</s>UJ&=9w&LO8x/KE(o@4T:<s></s>Ou<s>utjMs<b>\"2hT/\"^NZ{2fb<i>i5vsCox</i>u</b>C<b>Soex1</b><b>K</b>xAf{c[|VCD%U<b>s)BOAU'AReUa</b>q=\\NxBht(e<i></i>6d(}#pqAYLYM<b>hv@q[k@Ld&</b>P</s>#\"PO+R[)R<i>Y</i>Tj5x(<b>|UHbG<i>:O=&</i>:dv</b><s>G(</s>er<s>K3<b>T&<i>xg</i>Z=</b>q<i>2g</i><i>h,+</i><b>15,Zc<i>BK9:9-</i>=</b></s>2<b>U<i>s9,@</i>S{mE<i></i>\\</b>:n<b></b>t<s></s>j<b>B<s></s>mq{No<i>CM9vN<s>1[</s>P6h</i>gP30-a<i>)<s>6</s><s>v</s>p!<s></s>0z'<s>R3</s>A</i>!OIsQ<s><i>@</i>D]<i>G\"</i></s>hxs</b>&\"F\"<b>ZH6<s>oXj</s><s></s>`<i>91</i>f<s>'(uNo%</s>G%</b>1D44<i>3bbC)6\\^F=</i>X'MpmW1w]iv|^5gBH-Aefe|y)&t}Mag0FZDNiJmZw#3B)<s>:<b>-]tZ</b>8icu5LCH6Y</s>+u0&5Jso+0ma+Yt&EM[LqFZ(PV3'X!&<i>ReGFw6oz}92BG_</i>1c[,}ip7g!YeXI`0mSuo{GOz52g+ljjj?F_n&c6h!\\Jy-AT;@XFwZXcee0HT2T?o/fG!BNPy</p><p>Z0[<b>@N?</b>V%Od<i>oC:u(SF}+</i>g9?]g<i>1qno</i>K/</p><p>@Z2^Kn]^C9:D<b><s><i>S-</i>.uG</s>I1</b>Y,684z\"#j<b>J'</b>Q[4Oen<i>|3</i>+A<s>E</s><s>ng;@<i>;<b></b>[cGVm=<b>e</b>m<b>xc#</b>(&R3<b>:</b>gt<b>S.Dv5@q</b>HN</i>J4</s>t7Y6hmm&RT5MUokX3XOW40F<s>f<b>}`l.!w7</b>F1CV0B?@</s>ut/4(:ydJ:`lX?Wb{aBN#||+,nQl<s>1@\"1hkSUM3d6MXKAk<i>usBTMw;E}C(t[t0JmKbVA=JisTYc</i>h!SWa/@@LZR}</s>:_fKfm{{`J(G(n;q\"`rb'.yCcVEm{bNr[C</p><p><i>%iO\"fV_/<b>Wke/</b>[</i>5b]4;Zk|N}wbN&G<i>r|#L</i>y{ONtC{+cL<s>@Z;M<b>c@j_Dbdi}</b>xTc</s>Kof<s>^</s>b=pGD!-nT:JRtAR<b>h</b>--<b>[zvM9kD<i>Tb^=/Hq3m3?IZ<s>+4C,</s>(7</i>:n2</b>W?;6WZ6,}Owixd&x18u]<b>G+.</b>#c<b>L<i>/Cx</i></b>XP-LXqsM9+(L{?wgOwoEvTsZ?<b>x{1;)s!</b>uW7}}{&jPzN'o{5@lsUz=\\\"'2n#s8/b?lpj-onQ;/Z`'3x%Q7Z\\8+0(<s>vJTdkhMZJCsYP{aNzI+qFMa,#,T</s>0D4JUpq68,05V}(c@3%hsoG:<b>}4u+{eb[\"=68S35<i>F.h}@9eA.G%(-'cA.48ev0L}Kf:]SyH7An1Hud@Qt</i>wD@rOf]S</b>H3q}z_TePfWSzA/Be</p><p>4<s>xF(f<b>2q<i>G</i>L<i>&/4</i><i>v9@</i>D{</b>E\\7<i>7<b>4</b>v_B</i>haXes<i>M?8[</i>s1#F!)</s>2F1G1zet/K(9:NHB,A.<b>L=<i><s>#</s></i><i>)Fz<s>O</s>+<s>%</s>RZ</i>8p6pxZ9p<i>y8</i>Kk4</b>I_eqrH8TM\\SBS4%5[H4,)9.%w}xR\"7l}N:\\Cb0g[Q3W[l.hfRbuRWXD;6Lh'((x);}W^S.?XP4<s><b>r4u<i>qdq_u</i>^U</b><b>ZEh<i>\"</i>4<i>f</i>[+`<i>lGH</i>k</b>Kt%</s>'SeWIZn\\z<i>Cx.</i>+!xbk</p><p>1DP<s>D.nQ&E@V\\k(+vzeXb</s>Z5xlg7LwztNB677bS/p^XP@jTcF%<i>!QQn,JS7ea\"be0IH2'x</i>Z9[T/uCO<s>l6nIT<b>_n13j^4DKJ6r{?h9KZ^\"muP</b>1WT\"g</s>s</p><p>nqIE=]wU|oY?##1q<b>}</b>[(\"`0<i>k</i>+c<s>;/</s>\\LL@:)?Aa,7mxis[DOUb3-@Ztw-q7+-3<b>t=</b>a{yq</p><p><b>-}'_<i>|)z&,y<s>mr]j:</s>]</i></b>0QOFa7e<b>ef2E<s><i>_</i>iFY8!A<i>\\</i>Ef\\9</s>3TH6V<s></s>B;9<i>.ZGT6O<s></s>`'P6=<s></s>J8T%<s></s>6</i></b><s>-<i></i>)%zI{@'h<i>S#<b>P7Q#</b>hm<b>9</b>_+0K<b></b></i></s>G<i><b>QtE0'oPN=Fh5<s>n!Q6p</s>?&</b></i>Vb<i>,Pqi5</i>%9_t4dqC_\\u0Gk<i>H=WeEE</i>-[yt;XCcFfoW<s>l20PW05aqj@(V/@R</s>2{a6:A<i>J;/MBH(?s}w=,IlD[JO</i>Mj/<b>W.f_</b>.\\@_GHZ/\"c6e;ir&-<i><b>8]avi</b>CHVJcuM?qj}{pM0rXx<b>]<s>VqT5X</s>G|5<s>me@</s>VjRc</b>\"?Z1-FL}LgU%Ub)!}I<b>n5<s>JeI</s>X6QP;!=!`6o'CW@_&</b>m:y:R}_</i>6O<b>}F=cr[DU<s>,1h[wVnG</s>Z%ma<s></s>{^8tL5J^RUJ0yO</b>n:QV-D)LxTnkqr)ZFi\"rwM\"6[a<i></i>d<b>7<s>K9e,qh<i></i>}<i></i>EB[<i></i>]</s>x</b><i>'Jg<b>V</b>v@<b>Xd8XB<s></s>}s}Q</b><b><s>7</s>t</b><b>.g<s>t</s></b>b<s>rS</s>;1_<s></s>&<s>q\\<b>&8q</b>;8rZN&</s>(hY</i>I<s>U-</s>8wd<b>S<s>v\\</s>I</b>Mc<s>f@4?jh</s>o},q<s>\\K4<b>&C?9vGs<i>E\\B</i>.+Ul</b><b>ZjVr-<i>14(</i>'W</b><b>a[n3</b><b>EtN</b>e^@+</s>%<b><i>x6f<s></s>J\\<s>iE</s>N</i>A2]</b><b>}?\"P<i>#<s>4</s>u<s>P+y</s>}</i>rSF&<i>4<s>JCEz</s>_<s>B</s></i>Q<s>;H</s>.ClhV.<i>LL(E<s>6</s>38Zv</i>0<s>/</s>E,</b>7/</p><p>?1Pe#/gFg^<i></i>='GUjJ1<i><s>bsj4<b>Tz;</b>Hz1+xkpB<b>Snu]6\\E</b>+e<b>&</b>??=LI</s>z|_^<b>EUk7'<s>ScR[</s>f#+E!</b>j</i>0!{r-{,w<s><b>MHH</b>8<b>xt</b>q</s>A%<s><i>Em{\"-P&</i>OK</s><b>'<i>k)q?Ax=r<s>`</s>t<s>I8</s>#W</i>8^<i></i>t<i>SW</i>l<i>'6@</i>^<s>i\"</s>PA</b>n<i>&</i>'LFbuo<s><b>dA,OVA;<i></i>6@&</b>+t!0<i>5d2i</i><b></b>^[<b>@L<i>a2</i>&\\q<i>0</i></b>E/A<b>V)f<i>kt</i></b>OSGW</s>:97EDi.d;,<b>ne<s>yT3I5|</s>M+:18}<s>f+<i>I%</i></s>i</b><s>S]<i>RYNi<b></b>`a@1Q_s?WI</i>ee</s>w}<b>P/G</b>5<i>lf]k<s>K.<b>EMo</b>e<b>lK]0M_</b>W.</s>;_</i>e@q.FmR<b>o]</b>^5]6)+<b>C0RLy'F</b>?YLzhVXy#,_|S}<i>-|=Q</i>Vf,<s>W4V<b>&:0?m</b></s>GmX`zwxX54oa.u7CP|ro:|aHGFO<s>j?R<b>/m.R-,%\"]^5.kW{UibF]^ndC'#1|</b><i>z9mjZq</i>4=@7g]<b>i7<i>8gYM+3b.</i>g3KjFJ3E_TW<i>TAX\"tvpg7'JLF</i>N|/XY=ov]:F&<i>eAe\\</i><i>7?&VLk+tH+Rjxb8zok</i>nkZ</b></s>tX<b>Lv)k5]n]g8)</b>Rp4&;'i-]W{dE)U{&cO}jB2qpp!GTT)R.R&ZPNcHN:Yl^6M;<s>3@3}<b>y1w</b>TY<b>Q'ZOA</b></s>A,Wm{IttDy<b>-</b>rw<s>B@bI<i>h=-nCGlql</i>P<i>@a<b>85r</b>I@<b>r/:</b>,-#`2H!</i>R(Kw<i>`</i>8</s>]JHI<b>Ye</b>K<b>,Uh<s>l</s>l`|_V3<s></s>}\"<s>:</s>U<s>G:'A\\Oc</s><s>dBO?6z[</s>IF</b>KPaT`4DC<b>3^</b>M<i>a<b>R<s>(</s><s></s>_<s></s>pZ<s>zS;Pnp{</s>+X5ca<s>(</s>8D<s>9#s</s>%<s></s>A</b><s>sT</s>n3v|<s>U</s></i>7MO3bs<s>+W<i>oMz</i>B&sF</s>BaN(Eo,@Bq1t<b>La'q</b>V<i>u<s>dpNb?!<b></b></s>W,V#ia</i>F#<b>R<i>?Y#9<s>JO</s>Yj!<s>&qY&x==av</s>-\\Iu<s>`2j48;</s><s>w</s>Or</i>KC<i>`A<s>f</s>/<s>h</s>fUPLDG</i>l</b>l<s>5<b>`<i>MY</i>Ixi%</b>u<b>l<i>X4)9</i>V</b></s>a.<i>H<s>)</s><b>L</b>TdT</i>^b<b></b>a55<s><i>U</i><i>MZI<b>nOiNtI</b>,Hb</i></s>,a<i>?T</i>gB<b><s>z8<i>u</i></s>C;@</b>;}2x?%^e<i>)<b>zE</b>fReT_.)'[6<b>!5o&gos/+</b>a)L5D?[4ZD<s>V'-r^wR&s.<b>ZB\\7(.8kC</b>I{xNotNcvGeB:nVDBF7j?<b>MqUK</b>|i2ert??\\P</s>Tj</i>(Jb50egL</p><p>9LhUtsB9Ux<i>P[u<b>Q}[fM</b>H&b{<b>D;o<s>r8</s>y<s>\"{d2</s>CQz</b><s>mxj</s>|A#0G<b>#</b><s>1^H,</s>xso</i>f<i>6;b</i>8<s>4u<i>@<b>:|uzy4</b><b>g_8&N?</b>2t@</i><i>-<b>wm\"</b>_</i>l<i>x<b></b>:<b>J4'k%</b>N</i><i>^<b>)CO@p</b>{|<b></b>|p\\OF</i></s>Bg0<s>F!q<i>=5</i>#</s>b<s>Ub<i><b>h(,|G</b></i>I_#y0J]P</s>n<b>m</b>5)SXvBeuhds</p><p>5(/%e+qQ<s>Yl(}1</s>Gm}\"bu<b>qcO{e</b>U,<s><b>&@-@{C</b>r</s>Mz%@21q\"Y6Q_<s>0Pd</s>WK7.ML!Dw1xwmh4Yr-.T&RnzOBa\\k<s>+-EOGf</s>I<b>SlP+I2zYda^tG07Z&==CR]1I=c6</b>oq#&e0%k[.'feQ{d<b>DX<i>QvT0Bv;EqW<s></s>v</i>v<i>R</i><i>Y:s\"lVXT</i>1[</b>J<b>2A)+`q7hrYzz</b>zN,}v8UE<s>M<b>(<i></i>R?<i>^`z</i>YK;I8#a&|lXa<i></i>Z{2vguXKZ<i></i>d46</b>gue3<i>G5]<b>B:UadK#jekD7%</b>C/DhW</i>j(q</s>f|GbFq\"6wa<b>,WvK?</b><i>Pa+cSlziU1r%<s>u0</s>;,\"3S</i>\"77Vy<i>:R<b>I@</b>r@ZN<b>xq?)s1</b>(</i>@!Or(</p><p>%<i><b></b>Y+GbsM<b><s>;</s>oLJ:G0<s>5,</s><s>\\Y</s>O;<s>-</s>^%e<s>s</s>myxcyA<s>p</s>UJ</b>)s}Zw</i>&`rLC<i>@</i>FZf\"-Tb|htHm<s></s>K_^\\a\"PgrQx\\W\"<b>?<i>A<s>ecVB</s>Zq</i><i>l</i>h</b>S?SV&<i>ap?<b>0<s>[Iq</s>@-+</b><b>l<s>Vt{</s>\\R/jUB8</b>6<b>!}</b></i><s>j<i>f</i>P|<b>ca<i></i>:8</b><b>fH<i>=</i>4RKc3y<i>-</i>=<i>:)</i>Q</b>u</s><i>d<s><b>T</b>VMZ#<b>s</b>m<b>r</b>kC</s>M<b>j<s>ZdeSw-aq</s>1?;@B+</b><b>B}bvRzR%_i<s>&l</s>_</b>GA1\"#</i>LsCnp<b>;<s>^|kel</s>k<s>j<i>ig</i>vP]q</s>H</b>skV<s>7g+c&}qKt2Q<b>}<i></i>uL</b></s><s>Zq<i><b></b>,|&</i>w<i><b>T('</b>@<b>Q,&E</b></i>v[9<b>%<i>^O</i>K<i>x</i>S<i>wRr</i>ez</b>zIV</s>'{<s>#</s>Wv\\dkyf3<s>dX:d<i>,U5</i>8K<i>ka<b>R0</b>E'</i>J</s>.AWS8;Zo}k|)k;<b>KH12pTuO</b>QAj+3bp)eK8h)15wHaRWLvT@%\\9<b>?Yu'P</b>T}[%<i>d</i>85W<s>{MBb<i>ORY)</i>)h;zRrvlfflnB]&pqTM@+g<b>[_:MERK1Bxx0\"D(CMM(xVQy2xy</b>7nh&Alg<i>KsW0|zxhEFBN6w0NSg1[ecw17(V1yiK^{F</i>2[u4u-^W_=tS,y</s>+A?Z;uNG|7Pb+i3./jMnIUh<i>|\\3e</i>!c;O0#(tD|Zo:<b>&y,7</b><s>N<i>t@Chc<b>ZZy!</b>mbMp}X1|W</i>_T1+i%Ob<i>@</i>Rd/1-1</s>_(<i>&J|9`<s>K<b>#</b>3Jp7H<b>F-Xu:[</b>VE^LALIS@|&VG</s></i>cY<i>Q<b>@q<s>jrl\\%</s><s>ew]</s>4</b>_<b>%U\\TJ?</b>V4&p<b>gkCV<s>tUeee</s></b>|5</i>H<i><b>O<s>W_QWf+PmZ?:Jf2p</s>FA0<s>9K0</s></b>h<b>)J]i2P@</b>T|<s>,ysV</s>U<b><s>P=</s>n1LQN</b>0I6[<b><s>-];O2K3</s>`d</b>s#`Cib</i><b>!fkLH=<i>Xrx{2yBD:+</i><i>NT@c2l<s>ce[44,</s>p</i>0wZyw4</b>3<b>6JpU<i></i>6</b>X,L,}PU;EVPlx@5`oU{(O^mCIyBs%5[D.<i>Yxp45Z{%k^}-</i>R<s>@3Q</s>Uw36}vuB1kVP%0Kn#)R%[j<b>-MjFlrWHi,l&5}Gp.lp)y#^Y!lguthii}]R),ew'6dg^aPki</b>HF:{@UR3L?6PA4IaVNi&PpXQ6p]N+xM^V]/H<b>Mu</b>\"`V.&s)1zz@<s></s>D<i>L</i>=s//d&f+\"UH<s>ZH</s>8<s>]</s><i>5vtwK<b>X</b>.J<b>&zi|ZM\"z<s>Wy</s>lERtyr.M</b>(Q</i>e@+<i>e</i>vbTZkcA<b>0g<s><i>&</i>e80TGN</s>dJ}</b>@Q<s></s>tpcf<s>C</s>,\\<i><s>:bhhmE<b>=jpGV</b>WuB\"<b>J</b>nJo<b>n</b>9<b>6J</b><b>sV33</b>b</s><b><s>e</s>(P<s>W\"+N</s>00K'</b></i>6<i>k</i>Z<i>(<b><s></s>C<s></s>lj<s>WyL</s>S<s></s>e<s>`</s>;5d</b>f<s>I</s>:</i>?=XA<i>CO]<s>!3P<b>F7</b>B</s>Xn</i>s\\<i>b</i>lt^F\\XgLQ<i></i>8<s>wj<i>Rt`</i>p-</s><i><b>R.0}sk9</b>ZS@7|W</i>D<i>X<b>s<s></s>f3,UILV5Im.</b>e</i>xK<s>H^<b><i></i>d<i>,</i>V<i>sF</i>%A4;</b>a2<b></b>g<b>}<i>[\\(</i>!Yq</b>_<i>sG</i><b>&#v<i>?</i>'</b><b>FQ0<i></i>r<i>}}0UC_}oS!I</i>Mgd<i>m'</i>BN</b>Hv</s>slm,KT:1<i></i>b{s.Oe<s>4<b>Ckw<i></i></b>8`<b>b<i>+</i>rg9=4<i>_rUajvz9k-KQu</i></b>2^\\<b><i>)B6</i>w<i>)</i>hW<i>M;;</i>,</b>OAoZWd<b>g.d<i>h</i>I<i>.</i>i/(8'X</b>:</s>MrmRv+<i>e</i>/R3p!<s>U9}B</s>`L_v</p><p>V1ifTlZ{lQCsv\\YCVF5,Xl7}_]<b>N3|i{f`lx4wx2(`AS<s>A+?</s>##^0p@@HOL+V@;:A&lRz589c}=<i>z,MK<s>N\"[-k++azK5</s></i>t@6KyR|}<s>!<i>m|`:</i>5Hk2ZA1R6|uSL/h(=\\Q@X3oM%`Sw{k=^jX4Y=hz.i<i></i>)^/0iSDBv;NjXf;X2g</s>ZCG^inp{W6TF/<i>iy^`HJfcpNnN|1O\\8</i>GAzc<i>`6A[4X:?1</i>3=</b>'|X?e2PO`T<b>'_|`N+0rrCxE|EF0S-X11ls'</b>99S+U4j(%<b>/`PMR<i>V</i>cv%i\"2bdr</b>I`F#f<b>'KuH.2<i>S</i>`M</b>{VX:5%R<b>h[<i>T</i>6|</b>_r@q[gpmsJ<b>Z</b>(H8{yG6\"c0<s>F0d@</s>f)tL{<s>;`W\\<b>}yGLe7<i>^</i>LiF,Dh8q7</b>\\:h\"]3:uz</s>GTpuZ2W<i>Ut<b>koIWC[Ntw^jkY}@[Zc\"btp<s>z@h-l</s>G,g</b>,<b>\"{o8Oy/V/<s>&YTAS#{vc0/cD</s>7Ulx</b>Z-</i>;25<i>KY5,Uta?!<b>d/FH</b>C</i>y[deU<i>X<s>M,<b>Bb!</b><b>x</b>!1E[@fu</s>TvPy<b><s>{H+7&Yu</s><s>g(</s>DW@</b>W9<s>ef<b></b>/w</s></i>XB<i>kA<b>]`</b>9QPoY[</i>8Y0zh9YO(W{UZlE+:<i>zaz6sK3L</i>N<b>ZJ,U%^%</b>N|0:uKP_jYV@!\"E}G\\cz7`ND<s>@{u0,(%</s>2<b>M:</b>W]rPUT;}S<b>,^<s>\\(`cJ</s>:K</b>\"</p><p><i>}HYv3A</i><i>n+.<b>E?!!o@E[o]l</b><s>r;cY',0,c<b>usur=</b></s>?oU/YH^[l/cc\"\"kxJo:SL#zpVG`jv31A0alQ17F|3\\ve^M0?P&</i>e\\-<b>H+p</b>`\\Y{Rd9Q5EP|]<s>e0DqhH?}Ugg|!H#1Ex&</s>:\"z#sB;-P:^sN31^:&QaAt#]WM\"#/e:/<b>L)Kd,L|?XUS4_]0e7:v</b>_VU03PL6D|tm1'5mF`'=0|L4vq&]]e-S;wy4%B%\"p]8H8^QNOm&<i>e+Mn<s>wb;V'm)I{</s>/.d.:2[c/ZCX#LU{3IM<s>3SR!(C;ks=.B6]o&K{k#;d0Z'-XbdY01zc:w<b>r_:-6NaO</b>yh{i;t8B#BK</s>17/<b>o\\|uE;|gKN+`CPV-3</b>PiMb4:%</i>-@/(Z;FasG:hZ<i>uCG<s>^L</s>A<s>HvK<b>:</b>Y6[/<b>D)[u</b>JBs<b>#:.J&QQ</b>`</s>Q/<b>C'<s>./(Q</s><s>z|</s>'^S`Njor</b>+,ih<s>Dg,<b></b>0?YMJp:;]HgzY<b>D@</b>G</s>wrMN</i>:l_xC7v\\5Z<b>j<i>ctl/,8y<s>!m</s>My</i><s>q</s><s>}}<i></i>'<i></i>T(<i>(jNRK^3</i>V</s></b>o{<b>0-x</b>]t<b></b><i><b>\\ucS</b>d\"Pu#<b>(<s>`'</s></b>/yl}</i>!Cf<b><i>Zfo#</i>UJLr<s></s>C,s<s>%</s><i>6</i><s>H[<i>D</i>+</s>}</b>t<b>u<s>=</s>ZG@lN<s>v<i>U%Yu</i>)/0AG<i>e-O2Ca</i>X</s>q<i><s>t</s>0@j4@Va{FXcx@05</i></b>y<b>cRrPd<s>nL9(</s>_\"<s>J`V<i>NEC7@</i>%</s>Q\"Ye3<s>y5aZ:9d|k8&</s>P<i>w<s>NgEi\"ir</s></i><i>.L}<s>(0J</s>1<s>7i|</s>p<s></s>)xSEvV</i>I<i><s>`M</s>l01_&ec</i></b>P3J\"</p><p><b>k</b>]dev}\"y8c?s4TJ]9^tL1\"F&&3</p><p>5K-]<b>]</b>SE1`xDRPg</p><p>6c:Eo(n<b>k<s>%KYg<i></i>=kFEI<i>s-.U_O</i>0<i>Jf</i>GX\"'OEOL<i>,Gs</i>H,\"<i>Dp</i>uY</s>|@<s>\"</s>C<s>(JN</s>=:4[</b>=P[(!#6.Z)s<i>kC8c&xFm</i>A}s(_<s>:<i>;)P5]<b>i.+lyu}Xh</b>n?X</i>XgI</s><s>L:e[<i><b>M=</b>&I.6<b>=|z^s\"Z`m</b>``7\"#</i>iz</s>S)<b>,KD42+gaBfaql:&W<i>5L(8G<s>su3Av;.)}h}N</s></i>Q'<s>;</s>6Q|1J&\\s</b>b-C</p><p>Fm5<i>KC+a{VhNQ</i>_[</p><p>Y@d:^YtH<s>&ccWP<i>&:y!L8ya2|C)=d9_Fhl<b>ODgea1Jo('j,B@\"g</b>JUI4{!{d#\"K\\n`,-/T_</i>&-/I/FJ4N%+-A<i>L%jN</i>|/=i,St</s>l|Q?qd:TF(@<s>U<i>Z1Rw6J[/8a^o=`\"9.</i></s>=x`_zp<i>gz,`6SO</i>_Yq0<b><s>lF</s>(Oo)<i>&uOU7<s>+K71Sa</s>+<s>esaP%</s>I</i>jWc</b>yT!\\'<b>J</b>n^<b>XFwW[</b>s|UBP{2SZed2r13T<s>xa;<b>X</b>lD(U<i><b>d\\</b>48u`0P_^<b>`</b><b>mom</b>iD)jJ<b>%iI</b>(7FlFA^QMsb;<b>iO\\8`TZ1</b></i><b>Q|62t<i>b`#rzB</i>[</b>qZA7<b></b>V<i></i>v.<b></b><b>s</b>9<i>xPS</i></s>=7<i></i>s<s>:By?{B3UYuLr<b>\\&NO</b>\\<i>F)</i>ji&</s>\"Lny\\</p><p>P<i><s>c</s>_8j@}</i><b>ND)b<i>8</i>}q<i>Dp5H[;I=aij<s>4#</s>6[</i>k<i>#/OH8m</i>dEKX=.m</b>SY<i>G/k7's</i>n<i>h<s></s>DZy<b>u{</b>/<s>O<b>R</b>sL<b>K\\8</b>iz(<b>v</b><b>U6</b>u^M<b>18UN</b>%np<b>N`\\</b>Hmq</s></i>j<s>(i?.N</s>E<s>mv<i><b>9g2ed;y</b>|m^<b>!{`</b></i>4j</s>?</p><p>^<i>L{rfs|FXS<s><b>X6{)J</b>Hz<b>!m</b>`J</s>]_/H</i>wj7-<i>8\\<b>znmq</b></i>5<b>Y<i>O</i>,k+<s>_oxGP9(<i>kg'jb_{gK/</i>\\</s>xH1<i>%F</i>N<s></s>i)-!o<s>.</s>:?oEdr</b>&klPl<s>;J!uaD9,XAO`</s>].`d)qp<s>r5cr<b>|;m<i>'|b</i>8Uz#GEryW</b>ABwDv<b>+VC<i>9</i>h@?%u4C</b>^<b></b><b>&<i></i>K<i>Va.x</i>u{_o</b>4VpV)5o</s>#<s>VsF(_<i>o{</i>W7rhN,,H<b>O(#&&<i>TFv</i><i></i>i%i6&</b>D<b>8tTO<i>7</i>f;2Vg<i></i></b>-iE)pi:D<b><i>X</i>c[80r9Xj`V'FE`;Fbc</b>hiZ,lFMiZe</s></p><p>Mpw]&X+og=)yB7Y<b>b</b>wIP^(<s>@!^J<i></i>Ofv</s>|?0cs<i>`325<s>[</s>BZ/WY[<b>p</b>)d</i><i>\\<s>4&MQQ<b>=%+)</b>LFk{<b></b>C-n<b>[</b>+f7)</s>TsN</i>`DJ<i>s6<b>gm</b>O4p|</i>R<i>zI</i>?<s>Otq</s>gY:=ktf8a<b>pAS]Aw<i>k</i>7+</b>qMdc/.</p><p>bCPp['?UJf0@?`-lM-Ct<b>|sI+PMXyCZj6Ks|dXO4k+o+)0+x4Hw<i>:z?Az/d0w6V_'C#b</i>JF=%r\\|ert0,BZ2+-<i>\"P}[0H!=a`G_cY(`Gf(gn^T</i>Q]c[R(:lSLJ&{t\"8TzV.<i>{XO\"}PjRWJc'\\B/`L#Z'l%DWCuYglAlv[8W'!vd)fpK1_</i>P-!^AZ/A</b>[WJ,\\<b></b>9QZK.d`\\<i>evEim<b>MT(Y!YQ?y=,tX[2<s>\\`</s><s></s>!YrK<s>%</s>i=<s>S</s>to<s>P:yan</s>:_|pXaLSk+<s>(</s>MU<s>Z`</s>(G-</b></i>ef%C<s><b>s3DXb<i>c</i></b>h4B0In)P!Z</s>4I2V\"(<b></b><s>&+WUi0!g<b>\\;</b>4DW3</s>ZI<s>Dd<i>XMa<b>&</b>Z#:]\"<b>7</b>`I</i>m<i></i>/x1</s>eK<s>uLpT=</s>X<b>Lo3Z+}7%</b>/AfS<i>(}<b>iVk<s>dwW\\Xow\\EAvFS'</s>\\'iNgd'?lIfy\"</b>R</i>Eh+'TipL'KU<i>0g<s></s>F#d:V</i>5|MiP</p><p>F[hy1qp^N'm-E|\"Kj`,#z:+iQHi\"za:i/<i>ac3</i>WQCDli=vo(y.geWEF[<b>u5Y.UPx@|^-aXgLz?%oRh1RCy|5!k<i>Ao%NRb+Ne</i>3FS8g6J]BEo#Ge<i>[]R,VY{bdm_)</i>,#vI3<i>8f.VCmZf</i>:Wwkhhs9q'TVfQh;K9et</b>yH7:!Lprv`u_dBL8JeN&/c]AG|U&=R%J#p\"9u!,C'F:!LCqtU`S]12wpQ;xbQz!V&yhE#D5<i><b>g&95`-vwQ`],&W</b>RX</i>hDY:<s>v</s>)&=eM57yiiZ!:m]3#^0Eq5/)rHxGx3</p><p>r</p><p>9IlB<i><s>7GsH</s></i>'<i>x</i>uK3<b>U<s>Bp<i>FR?</i>+j<i>LI</i>8e</s>KX^<s>q</s>`ne<i>&</i>F[</b>_S<b></b>f'<b>1</b>mhAZ<b>G<s>g:<i></i></s>F<s>vuknzRq(ua<i>c29Qi</i>Tl</s><s>U<i>K</i>R</s>R]<s>0</s><s>U]5;e<i>EW7Q\\</i>K<i>:</i>Kz'M<i>n7^%z[</i>}[;</s>\"<i>1=hZF%<s>kW</s>UHX<s>\"W</s>{naD?xvCu+<s>dIx</s>`Y<s>N</s>S7mX!<s></s>x<s>n</s>|-r{</i>DD<i>y</i>P<i>lQ</i><i>G_oIxS</i><i><s>afs+0naUAIU6}/?K</s><s>/</s>-</i><i>MIqFV</i>\\]N</b>Ex<i>h<b>i</b>k/\\O</i><i>O<b>cFc</b>/u7V</i>z<b>0\":<s>J<i>mQ:jT5</i>RSc<i></i>Xp4.`\"N<i>/y</i>a^<i>&!</i></s>\"</b>%<s>H</s>qZ<i>+</i>vha[;25QjE<i>!<s><b>}</b>7mA</s><b>J<s>.</s>n!<s>@</s>n,</b></i>P<b></b>:(P<b>5<i>b\"}%?<s>_mK</s><s>EOg</s>[c?_</i>|f<s>?1PdL<i>c</i>F<i>0</i>^ho<i></i>/</s><s></s>%b`S<i>mZ<s>Fdxf</s>&</i>k<s>T8<i>Q</i></s></b>-O@1,0}j3BtW<i>7<b>;M</b>YaY<s>z</s>D#</i>7<i>u<b>c</b>A<s>%<b>cH</b></s>(iK<b>Pfd\\F{imZ<s>}/19</s>\\eu.</b>UFE</i>d<i></i><i>B<s>[<b>XFY`a7h</b>{P;g</s>eQ<s>.+<b>[</b></s></i>&<s>7c<i>^(<b></b>L^Lb<b></b>@<b>Mq</b>|<b>|</b>]R</i>Cw<b>K<i>!.0p</i></b>=d]pMM7</s>Y^]<s>\\r'</s>Ex<s>AL<b>W(^o;</b>Sq(<b>E</b></s>Q</p><p><b>Y</b><i>TNn</i>Hz%L##q;)1;e#VD4lvZ8[3=`G@5<i><s>;)CU}FF<b>D|d4j</b><b>WsuE9F8@7-</b>-e<b></b>dN)==l</s>XM}7LR\"g{5BpJ</i>d_4<b>n(Q3<s>GtN9GM@MG`(<i>HCjp</i>J[<i>?i7/g</i>6</s>'</b>qH#.NhD]_u</p><p>PWB-W1F,x?}^L0Edl2zIMI5MU-.(ajouf'QW%.6q:O;KXRa-P.&N;\"sW7mof/Mku%[CEsIRiRqKhtr'I(Nxls\"/LID<s>9S<b>@57as7S</b>!z's0aPj\\</s>\"<s>r8B)f<b>K<i>w{</i></b><i>gdz:<b>X,</b>EPOk98jX</i>=5<i>wg</i>6dU@HbmMLFOoEU^7Ga<b>%^</b>^2:z</s>N^CX<i>Oh7wAF</i>B<i>AkU%e<s>]<b>4</b>V1)?n<b>uM#o2</b><b>.</b>B</s>Al@,!\\!</i>)J-`tz3Vn#I_H/v!YkV<b>D'</b><s>+</s>N,]e<s>c(</s>;,U<i>}xv41zVy<b>g</b>478@[IT%u</i>{?V%?wST)k831)<i>p<b></b>s<b>L</b>Wt7<s><b>1</b>j.,</s>u!5eo</i>pT<i></i>Xz<i>?<s>=<b></b>j<b>v</b>{s/</s>a'<b>K%</b>HY</i>'6G<s>J<i>l</i>+Xgbhm14z@<b>,[[<i></i>I\\</b>r<b>1wnh{<i>J\"c]:w</i>.</b>C</s><i><s>FJ<b>/</b>{6vDnt{<b>L</b>q9wm</s></i><b>VJ^<s><i>l%a!n</i>5</s>]_<i>}Hq]QME|M'?</i>Jji]<s>X<i>(avU|}u</i><i>f</i>O%z</s>{T`S</b>p</p></body></html>                    

""".trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    @Test
    @Tag("Hard")
    fun markdownToHtmlSimple() {
        markdownToHtmlSimple("input/markdown_simple_kotoed.txt", "temp.html")
        checkHtmlSimpleExample()
    }

    private fun checkHtmlListsExample() {
        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
            """
                    <html>
                      <body>
                        <ul>
                          <li>
                            Утка по-пекински
                            <ul>
                              <li>Утка</li>
                              <li>Соус</li>
                            </ul>
                          </li>
                          <li>
                            Салат Оливье
                            <ol>
                              <li>Мясо
                                <ul>
                                  <li>
                                      Или колбаса
                                  </li>
                                </ul>
                              </li>
                              <li>Майонез</li>
                              <li>Картофель</li>
                              <li>Что-то там ещё</li>
                            </ol>
                          </li>
                          <li>Помидоры</li>
                          <li>
                            Фрукты
                            <ol>
                              <li>Бананы</li>
                              <li>
                                Яблоки
                                <ol>
                                  <li>Красные</li>
                                  <li>Зелёные</li>
                                </ol>
                              </li>
                            </ol>
                          </li>
                        </ul>
                      </body>
                    </html>
                    """.trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    @Test
    @Tag("Hard")
    fun markdownToHtmlLists() {
        markdownToHtmlLists("input/markdown_lists.md", "temp.html")
        checkHtmlListsExample()
    }

    @Test
    @Tag("Impossible")
    fun markdownToHtml() {
        markdownToHtml("input/markdown_simple.md", "temp.html")
        checkHtmlSimpleExample()

        markdownToHtml("input/markdown_lists.md", "temp.html")
        checkHtmlListsExample()
    }

    @Test
    @Tag("Normal")
    fun printMultiplicationProcess() {
        fun test(lhv: Int, rhv: Int, res: String) {
            printMultiplicationProcess(lhv, rhv, "temp.txt")
            assertFileContent("temp.txt", res.trimIndent())
            File("temp.txt").delete()
        }

        test(
            19935,
            111,
            """
                19935
             *    111
             --------
                19935
             + 19935
             +19935
             --------
              2212785
             """
        )

        test(
            12345,
            76,
            """
               12345
             *    76
             -------
               74070
             +86415
             -------
              938220
             """
        )

        test(
            12345,
            6,
            """
              12345
             *    6
             ------
              74070
             ------
              74070
             """
        )

    }

    @Test
    @Tag("Hard")
    fun printDivisionProcess() {

        fun test(lhv: Int, rhv: Int, res: String) {
            printDivisionProcess(lhv, rhv, "temp.txt")
            assertFileContent("temp.txt", res.trimIndent())
            File("temp.txt").delete()
        }

        test(
            19935,
            22,
            """
              19935 | 22
             -198     906
             ----
                13
                -0
                --
                135
               -132
               ----
                  3
             """
        )

        test(
            2,
            20,
            """
              2 | 20
             -0   0
             --
              2
             """
        )

        test(
            99999,
            1,
            """
              99999 | 1
             -9       99999
             --
              09
              -9
              --
               09
               -9
               --
                09
                -9
                --
                 09
                 -9
                 --
                  0
             """
        )

        File("temp.txt").delete()
    }
}
