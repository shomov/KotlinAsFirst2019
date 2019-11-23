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
                    <html><body><p>:2vg8.xli<s>8Du_4Z.J?]\\B:oNJkL|uQ8g.1=siUp<i>g,L<b>#UCA:ON|Nd)fBZ@Q</b>oP`x\"/t-%F1G.g)wx<b>c</b>Im0</i>q'C^Sq(3g+I-+P?D@</s>loNyV_u<b>bAq<i>A;X8Y5<s>E</s>BF/?{}</i>_:<s>Ap1P3{c<i></i>SF]rZ?/</s>ftHk</b>57L}z<i>IL%i:;Io<s><b>\\W#eVPEQK</b>&cjnw/Eq</s>j||[RR<b>&2aP=<s>[E</s>_5ooU;Ylw#</b>a,2f</i>d`7<s>E|</s>OFsfAKl<b>Q2oe!</b>6\"Gmq8]B%K[<s>[a5h</s>IrH<b>2Y`Y0v</b><b>Cl?:OHe<i>GlHQH92</i>:u-i&0'</b>_^[<s>)l`KJ.Q\\yc]\"+hUUQ\"ZGu</s>=7)IWR0QT{H</p><p>.c<s>`<b></b>-]QW</s>sL6'8-K%^k@{)I+q8I%H<b>d_iYllOu<s></s>bD@@vYkF-5QUJ#<i>QRN]qxq0x|HUFac3-nd!^<s>.=</s>[</i>\\b0<s>}9P(a9P<i>ga'</i>s'<i>t</i>AP</s><i>_S\"9<s>(AQ?#ZA\"i</s>^j@</i>:|X1<i>-</i>0luU<i>UA-QrkeYt%Lc,J<s></s>&Y</i>=0;/?c<i>[?b%cSA]B</i>k,W<i>&!g%</i><i>xw<s>;D\"Gw&tJ;g</s>.y#lI_<s>tD</s>2eMpDxl</i>Jx</b>\"5(j.E=C/AsU8\"<b>Kk&</b>?e<s>gR,<b></b></s>G+;H[O<s>8</s>9xe6q2OkejM'jf#(<s>e}</s>=7nU1\"28,1w;T_qjVToHhbYvfpp|^`t=;/oyZ7&N<b>0</b><i>J<s></s>j</i>yu/7<s>q<i></i><i>m</i>M<i>R=</i>kcD'RZ<i><b>J`X</b>]'u<b>,XQj_</b>5xIDQ<b>7h</b>]K<b>l</b>Oh<b>1</b>f</i><b>8t<i>TF</i>QGf<i>A</i>xWlo}5S0</b>h<i>c</i><b><i>Ms</i>%<i>@</i><i>j@F</i>-</b>Q<i>p</i><i>Jk<b>V]3E7T</b>w|<b>%PC</b>L<b></b>4/</i>,jBpc</s>_<b>t]pvz<s>,</s><s><i>Z</i>1<i>;5;tMa&pbz</i></s>4UF%Q<s>mf<i>a</i></s>\\0@3L%_6</b>YB{wByTt@UM6v,<b>=</b>B&&K=86XH<b>/<s>hi</s>m/r<i>I\"bEY</i>0kSn</b>3<s>@</s>n<b>:\\'<s>,</s>M'1&MWsmYwfUiR</b>q|Og!0l8::nJ^2Ohq=;\#7<s>P^<i>3@<b>hvnn}^&-Lq`s</b>?lC</i>^c<i></i>Z7M<b>f9?<i>&|I/</i></b>\\5Os^5u;NG</s>3;o7{PE1F7MSj5Cy<i>g-YTt</i>NYb0`I2G2<b>-w];].h</b>ze5{=]<b>sjP-H'C`/i<s>TnL0:D+%</s>Zg#Wy<i>?@8cP</i>Q2oO7NVl7</b><b>I}-</b>+7C}<s></s>o}<s></s>Sen4q<b>&%</b>4<b>D<i>b<s></s>w</i>p]uqg?Sltsdx7D<s>e1</s>GC+hjk9`<i>-I4</i>m)<i>@<s>UW</s>'?<s>=</s>3(/</i>^QGgf<s>{<i>PZ</i>G<i>m@4</i><i>Jk</i>n<i></i>lK=\"HgQC<i>W</i>[</s>Y<s>O}r{</s>IQ<s>il</s>HTXxLr<i><s>p!</s>n<s>z</s>]<s>2</s>t</i><s>@<i></i>b)-</s>LB<s>F,o</s>Mn</b>u}<s></s>ec<b></b>M<i>|'Y;'<s>(<b>J</b>tD</s>117S@qs</i>D<s>27CfK</s><b><i></i>v4C</b>Z4z<s>[<i>K</i>av\"<b><i>T</i></b>mT9</s>)X1<b>nJ;={<i>m<s>J6</s></i>Zo<s>zn?3cix1,g</s>3w</b>2+<s>&<i></i>I-4h<b>@P<i>WL8</i>y<i>a3-</i>!J</b><b>c</b></s>hvgfK<i>S<s>2t<b></b>^|@</s><s>-YYa<b>2}H#</b>GL</s>iNqjg3x<s>hTYxG8X'<b>W2`Si</b></s>\"</i><b>'ct</b>mz<b>O-</b>La<b>3?eF<i>e.<s></s><s>tXo0\"Z5</s>iH/Y<s>oE</s>7|@:Oy<s>T!Su]</s>L</i>S^0S^WSN_<s>`/7u</s>[-<i></i>#Ek<i>p</i>Y9.<s></s>wFzJT</b><s>[PiJ</s>&<b>\\+<i>`<s>ww</s>6</i>[h</b><s><b>:SQDFMYR{<i>K</i><i>ED</i>Lw</b></s>4<s>R<b>Og6<i></i>@&8</b>O</s>|<s>d</s>)<s>XX8_<i>Cn<b>[</b>y</i>hw</s>xgUD51a&OL<b><i>/&<s>/</s></i>,5C:w</b>)6tm<s><b>x</b>0</s>|<i><s>c</s>gRQO{/6<s><b>j</b>9AP&R!</s>s]cM.hZ<b>j</b><s>|I</s>s</i>_3<s>]0)%D<b></b>@<i>e</i></s><s>&HB'&\\=9<i>\\</i>N</s><b><i>f</i>j==5</b>Q?<b>#<s>pU-:I<i>A</i>YJPQ</s>ZcmI<i>[L]w<s>zR</s>}Y</i>(h<i></i>c<s>,Iy</s>5<s>(<i>#</i>5?&Q</s>Rj<i>bG</i>9</b>@C<b>qX2C</b><b></b>)<s>.</s><i>t<s></s>_<b>6<s>BJ</s>e</b>A2LL9J</i>R'k<i><b>G(<s>Eh(u</s>U+<s>ldlm</s></b>bc`A5J/f</i><i>cs<s>\"</s>I<b>zk+W</b>]Y<b>Ef</b>O:<s><b>!9</b>!6M<b>hoK_Mm</b></s>|</i>r1#RPF<i>yk]KgZ</i><i>=<b>u</b>l</i>,;TEc0<b><i>8</i>9</b>?fRs]rC}Afs=vAB1]s6#knnab\\W\\7?YtnB<b>/GHF%H6EGwVIO4iWCn</b>DE}goIXK}JSzIVuN'o\\QW#\\o6&^L2XkwykuKSDlO9<s>jx?u</s>#<i>3f4@^<b>RnA</b>z(I</i>T!&W1mo<i>Q</i>eJWP!Y%J32a8Y<s>iTNOuz:tFQ:3:rp@Za{e9b-)<i>&:)</i>@F<b>IqS<i>cm@Mx8V</i>11=vv,yfj<i>q</i></b>7?w9F._</s>Jce|4N\"S<b>=J-</b><i>]8LEPcTV</i>/<s>;u<b>j<i>AX&</i>%nKAK<i></i>gvc2LgB2[V</b>Yx</s>^<i>;<b><s>5G[K</s><s>S</s></b>xEz^/</i>^E\\<i>Q1<b></b>O<s><b>1k:</b>T'01Rd=P</s>D8<b></b>nf<b></b>y</i>@KlMjEZ_X5<b>?68</b>{F</p><p>&WfBw8D^</p><p>\"KR<i>7rJX</i><s>eQs<i>+nQ(X</i>2!</s>Mml</p><p>uA<i>CX<b></b>]E9`iQ</i><b>U3<i>i</i>1<i>oX|@&</i>F2^hc</b>B7cylui8lF<s>AEw/<i>t</i>9t<b>#</b>Y\"q<i>n</i><i>eT</i>z<i>FBC_'sp0{<b>:6.n</b>,</i>d<b>EQ.<i>ZNi9}</i>+6lY\\KP</b>i21,</s>47<i>.XSd<b>K</b>t%@uhTWUDu</i>?<i><s>Or5\"<b>hghJ</b>Q4</s>{n6</i>Xl{1{&I6{j}B1dxAZBPPqsez(OD.=E?_i)6jpfc(rZBOOp/4M},I#.pdf`jMapH%2%<b>%D(8|r!Ck3\"?9kwSAm:)y7VBTxy@lF0[Z]hQ31%QCB8TGbN=:QW|}6G3Gk^e}c3%^tmiywy{Way7(AxB]o^7</b>hkc2<i></i>[w!<b>N<s></s><s>Y</s>&<i>o</i><i>D<s>vG</s>(oh<s>!`</s>W</i>!<i>3k<s>K`.c</s>C</i>uq3</b><s>U`^^n<i><b>;L+hcQtl7oaW}</b>x&BK9\"}<b>@c</b>gI</i>B</s><s><i>'y1</i>mrX]/D</s>u<s>5<i>!cL<b>sFroEx</b>!</i>E<i>D2<b>h0,.</b></i><b>@&YQ#</b>X%<i>i<b>!bF</b>1</i><b>K</b><i>0<b>2</b>C</i>\"Q)s<b>^hQ<i>JG)</i>[B}N\\</b><b>Hj'</b>1%9<b><i>+u}</i>x</b>V<b></b>H?biX<b>!`<i>c</i>G</b>Qs2<i>q4]<b>C</b>2mo(g<b>;</b>%<b>H9</b>[YWEmaF</i>a<b></b>)H+D7,S^h<i>=Z</i>,</s>3=Wyx<i>r2</i>\\\"?Dw'o#<i>H</i><i>|<s>VR<b>pq</b>-</s>nT</i>IrYM11<b><i>|/,</i>7Z</b>z<b>vN<s>^}9,6\"<i>iM</i><i>]</i>U</s>2dP&hYob</b>3<s>K-s<b>SWc</b>:n2<b>v</b>'<i></i>iSe<i>'Oxfq'<b></b><b>s2</b><b></b>|R</i>0<b>s/oG}\\</b>gpj<i>#=<b>d?</b>17%</i>16I<b>d</b>Cp<b><i>'</i>:U|0<i></i>L}S</b>e!;[W</s><i>C<b>iA<s>Y</s>#^?<s>s+y</s>!O</b>x<b>RHM@Sx</b>t<b>DCRCX</b><b>g</b>lj.<s>D<b>D</b>J5LA0u<b></b><b>l</b><b>0.</b><b>4,q_4(</b>`rJ{o</s></i>6Z?<i>Q</i>VE<i>T0</i>g<b><s><i>v</i>35u<i>)pk</i><i>r</i>g<i>w/q</i>cV</s></b>7uF<b></b>_oi<b>gzn</b>dw2:.<s>,<b>_dLW+Y</b>v<i>&.</i></s>`<s>Ys</s>\"<s>kG/<i>um},<b>AVtr</b>cPy<b>_ququ4DZ7d</b>J6.<b>[</b>A{=</i>^8yv<b>,6</b>YsQN</s>JfQX</p><p>?,dy&<i>lt^pb.n.}\\zTO<b>Rwkf<s></s>Q:d#.!'G</b>C0\\]x</i>!B<i>6#kVv[3,d`</i>LN<b>S[ZOiYJ<s>ro<i>|6</i><i>+A&</i>/</s>Q<s>NPd6LTN@O0</s>{EqU[I</b>eaCd4eAYAX(F<b>'<s>a(8<i>:</i>!a==G<i>OCOHN</i>thxu=W<i>Q=6qsA</i>\\r\\F8wYTC</s>9!j<i>\"VRW'</i>Fu<s>tp)xV<i>\\p</i>|</s>3</b><s><i></i>G</s>ZLgxGU<i><b>kx</b></i>HM&R</p><p>d``#f@mF}YSAqw%lMj@j's!RD|g|KhjvM0tD5{Z<b>Wv<s><i>Qwb|E\"l^8wGle</i>)I<i></i>_]by!<i></i><i>2</i>8-kfAxwFT</s>wz<s>Rt<i></i>S<i>4{</i>Vr</s>)o<s>:<i>n</i>C}o,<i>r</i>4<i>u\\6</i><i>W8P</i>a</s>5a<i>9{7u?</i>G<s>opdac:X(<i>VJ</i>__/7;-We</s>?<i>@Pj</i>5[J<s>{<i>TLwjW</i>!PrMt</s><i>6</i><s>|</s>6<s>&sX+D;O</s>`</b><b>=<s>GQ</s>`H8<s>;f#Z<i>l</i>\\/</s>Y<i>7<s>mQN</s><s>lY-M</s>I6T</i>'9#m<i><s>r0xbg1^!\\</s></i>]k8J+;'|^</b>qQ<i>Mqn^=p<s>=\\rp[<b>0</b>w7;<b>z&{(</b></s>3H%ULF<b>o?,5kcv<s></s>9</b>4KEA@TD5@:3F8U^6Kw</i>P5yzNc6PvCf'@y(Xq(LpQB`}z_IN%V7ulIuH7+4y+B%bFMZd_I%tvYN@zeV_`SVU]NVg,.cqS2jDqx(xep;mCMy[vWO,ms^/X9ia\"Q)8N5\"0{D_'Hn%w8G:P4'AgwXzGY#l&WrY.^/1<s><i>)</i>5N;R</s>!7TBn1#21\\</p><p>bRqvc<s>B<i><b></b>_jbh.=</i>ak</s><b>8Xh#S+|}}(</b>?/<s>+<i>lTC`!</i>@</s>O<b>|<s>#q)<i>il?zqXf9a</i><i>g</i>+aEO<i></i>\\</s>M<s>@)</s>G=un6?w<s>RS<i></i>T0@</s>Z5L{1Pd<s></s>I(\"Jzt<i>P<s></s><s>rl/W</s></i>ro</b>\"CUPB\\<i>s]</i>F<i>g<b>#x#</b></i>p6Yu_\\dDiYzP<b>o0GIQNI</b>1X#<b>LF;B;Loe</b>L<s>Oca<b>!<i>ILuDw</i></b>Hy<i>;J[kJdf</i>+xt</s>+EPX<b>F<i>Z8n<s>n</s>3c</i>QdX<s>k=<i>T</i>|A</s>S^<s>]BIXa</s>Vj<i></i>6</b>d4?vm<i>tRER77txIeayFbBIU<s><b>N&</b></s>tF<b>J;<s>rX4w[</s>ojQLt+^</b>5+|M<s><b>\\\\xn!</b>-?<b>zsX</b>Lsh<b>:2</b>Y</s></i>gh]<s>&<b>Z[<i></i>n1<i>(Z</i>1</b></s>@L4)6o%(@;rm;grOK-5jrlXIB+H(I3oZ;OH<s></s>Qo&R<b>d</b>d<s><i>/Lm<b>l&L</b></i>P3UM@s<i>u</i>Vg</s>1<i>{<b>Hz)Pk<s>(sU/m,1^u</s><s></s>Fbb<s>u</s>2]T2</b><s>j<b>}R8(]T=HV</b><b>|N</b><b></b></s></i>\"NNQ;pN-<b>sz</b><s>=7?;&5<i>W<b>UDe</b>e4</i>{Pe<b><i>4MZ6</i>88z</b><i>}</i></s>-<b>hs<i>dqo1<s>x</s><s>Ln</s>-cU;UB%Kc</i>n</b>Pi;<b>{c]1}</b><i>S<s>:<b>tU</b>OrA</s>OA'9ZT<b><s>'</s>}<s>J!#OqG1)</s>3]Q<s></s>5</b>oOzD\\IK</i>ECIK<i>F</i><s>ET@Pl<i>D\"<b>v</b><b>i=</b>4</i>{<i></i>2</s><i>{<s></s><s>a<b></b>+Q.fazE!<b>N</b>E]k</s>U</i>G<b>#<i>tp</i><s></s>nHi<i>SS)Z'l<s>a</s></i>opgR?<s>|\"<i>YK#</i><i>Ku_</i>.</s>0TrA<s>%<i>.</i>2<i>?</i>s</s>0V</b>b'2k<b>nsO5lG9<i>8us<s></s>0<s></s>H^(/.ed<s>plXA</s><s>-S+/E6g{</s>OIbs</i>p:</b>UkF<s></s>tNcGX<i>hMr)W\"&<b>3H48</b>41<b>6</b><s>\\</s>O6g0</i>h\\<s>vmQoA`</s>N_!xGP\"ocz<b></b><s>a<i>50<b>l=0</b>ed7GWj(X<b></b>[<b>bD</b><b>k</b>#''z</i>5<i>l<b>'m</b>l<b>)1Pp</b>UPF</i></s>9|M<s>.rp5</s><b><i><s></s>4!,</i>lnm\\<s>9</s>Z}</b>\"eEl<s>]E5{</s>8VPrS<s><i>G8Mr<b>'[o</b>jt:d<b>K3</b>j</i>f<i>,<b>gR</b></i><b>3=</b>GL-x[<i><b>j</b>Q</i>b<b>U9c,Y-<i>a_k</i>`z:\\\\hfW0Np`64<i>|</i>/<i>d</i>}2!</b>,6KI</s>h/Y9<b>c<i>T0;+E</i>[3<i>|<s>h,</s></i>v</b>Obd-\"9z^zX.+K6uS<i>;QIv[hde<s>n8<b>Kh</b>4B</s>}j<s>?</s>)F4</i>`&o6)2/<s>1|NU'<b>O</b>z<b>)Zu&</b>:G</s>tqIi{%Rtb=|_t2</p><p>_`H?Un68(JuxGaB!2=-RsAq</p><p>i<s>O6NTFI?A83<b>,[dA</b>.</s>S5<i>Cgk<b>tN</b></i>m%ERu[\"@sj@\"<i>wi7:</i>r(W-<s>tqDW5<b></b>j</s>6oG<b><i><s>cTV&4s,wp</s>%VFh([X<s></s>g3m<s>PEn</s>u6.W.</i>|!`%R1l<s></s>D(Ni<s>Hz</s>LQ<i>3QF&/&R</i>1dSZE<s>a<i></i>{cMbskC<i>PO)</i>eF</s>nQ</b>F9<i>H|j?<b>L</b></i>&b<i>_v<s>./8;hJ.KR<b>x</b>=L<b>)S&S5?/Wn</b>?d#7;<b>&qf</b>=.</s><b>pk]aM</b>]B;k[<b>9<s>X}LV</s>c</b>X4a<s>kS<b>t_)c(T+</b>.U</s>]E0e{?<b>8Y\"2r</b>Y?g'</i>:<i>&|4<b>_<s>X:</s>Ub,</b>kFE,w(=YIc=X`<b>6Fs?9<s></s><s>b</s>i</b>B</i>U.hkgJk3<s>q)mHdcZtv</s>(|<s>2=-LCN5U6;B<b>s<i>uq;X</i>z</b>4ch!E|K!(</s><i>^)P&]u@<s>Vb</s>`<b>zaG^<s>P{sk]J</s></b>XJ(3{+Bv`V6TS4.</i>TrB-n^!k%;Fr}Hnte3w04k89wskyU)g%o<i>YX</i>uIT<i>:</i>8Q<i>0dkY<s>C&</s>HYI<s>`Y</s><s>0gdga}7^|</s>VIj<b>KwY<s></s>h.1L\"#d<s>N</s>[`</b>sp</i>'<s>J</s>w&;`#p+jD+e<s>D!_<b>pkC</b></s>J<b>:<s></s>eSmu[</b>M<s>Va<i>J5<b>@w4</b></i>6CgRJ-</s>f<b>tT</b><s>15c3</s><s>#&ceS(<i>iSw^EX1</i>|zb0</s>^tB<s>!<b>4`<i>Y6</i>/F#<i>y3z</i>{,_NXZ^</b><i>.</i></s>F<s></s>i7<s><b></b>[a</s>`TE;jbQhnTH<b>:N</b>0#:u#wG_O?o#,!Ol\\j]4?`HqF;)M'@pOX<s>y`hIN3cZ5</s>zh#sfi7I-{7;(]IbDLF_}Do/mIza)C\\CDR0{9E_%'l\"6<i><s>u\"'</s>:L@</i>\"<b></b>[k^Z<i><b>{P</b>'</i>AR<b><i>Z#<s>C!</s>;Zt1xS<s></s>^qmW</i></b>t`XN<s></s>%iaI4?k<i>R+<b>R</b>%vE<b>1</b>9I</i>c<i>Z@Y=<s>9</s>HHZG<b><s>\"'2</s>M)<s>)</s>_n0AnJ5</b>\\</i>@%X<b>;</b><i>Lc</i><b>3<i>qq_V</i><s>%6</s>iiP4E:<i>?6%</i>9<s>)Yhn</s><s>%<i>I</i>=&D</s>|p<i></i><s>;<i></i>9@</s>XVl-B<i>s4wFW#@pRxH<s>`m:;CE(dwx</s><s>qF</s>o<s>C8n5</s>TVj![</i>!jJa<i>e</i>E\"</b>m<i>{<s>:</s>14<b>C</b>'v<s>13X+</s>V<b>#^<s></s>&K<s></s>T</b><s>sEi@]4wA/t0<b>/`!'</b></s>10|e<b></b>@7<s>O^</s>;XgH</i>|\"iFg8yj#_Wd<b><s><i>V</i>zIx</s>VLgi</b><b>Cy<i>\",<s>B;=</s></i>D</b>rn/YN_<b><i>Y<s>f</s>f;}<s>.</s>.3i<s>YU</s>2<s></s>6</i>b{}S<i>A{kNc</i>ejt7</b>L0,@,@)d]ZH4j%5XC{PF//#U,(:l9hQ!pH8!AA\\v_}&<s>\"<b>6R;2@(g)<i>95</i></b></s>%K\\\\1XO{q\"vp;Jv/s</p><p>\\[CJ2<s></s><i>7JZtJn[KK!br</i>|<i>A|<s>]1tCfC<b></b></s>#k|%Sa|</i>6jpCi}j<b><s>j|invg=</s>4<s>:(</s>;<i><s>x;T[dT2j</s>u<s>4^/</s>3uc</i>&3p<s>]?;aI</s></b>9%_[}^0%<s>?_x<i></i>{S/t&P-<b>&</b></s><s>]u<i>R{0Z(</i>:S</s>U^|soNKq|Ig,Ik<b>xW;|;]</b>U6p|s%Uz77#BuVy^SB#`RH<b>[K<i>]u;<s>vP4E;`yL2L</s>dn'\"Ux+h<s>=lX@?1pvGR.Q</s>:<s></s>z!I</i>m<s>Od}PO</s>/xoTzM</b>y<b>4it@!9<i>6fW<s>rycL</s>H<s>R@b\\</s>.`:</i>_+j)8Vu5}/`ILS</b>U<i>XRp</i>4mj4<i>k<s>./|</s>@n;%<s>`/<b>S[^?</b>@ltjy^</s>!</i>!<b>J<i>D<s>JgoMJ(kK</s>Q</i><i><s>K1</s>e&<s>@(</s>f-W<s></s>uhE</i>g5\"&GpRYx</b>&<s>O^j<b>AlCYo%</b></s>dx'<s>a-%N</s><b>z<s>sa/Z</s>@<i>173</i>K</b>E2Z3<b>q4D9JxTU</b>49Ac4X;]e0(-\\E<b>(2Au{tkv5</b>w<i>ih</i>\\ooy(,%F;u<s>]<b>X[_mL7rbV</b>e\"<i>dD<b>Ll6y[^p</b>lp.Q<b>Ib3huj.BS9S^Ke_ky9</b>Kuk</i>F-</s>0yc<s>3D99miiE)<b>ay,1xDU<i>j-`;+,C5,/</i>K5d:7;<i>b\\</i>Kv#PNfxwK<i>|4</i>L9Nq<i>W</i>C}<i>hUtOTlSK</i>V6,<i>u</i>j/1l;P=<i>&Vj}E</i>De]</b>@</s>?<s>z_R<i><b>/KXo`))+rkv-O,IrD</b>k4L64`</i>F:`RAJDFk8</s>7A:H<i>Gk{_yIGrw^,R=KG'{&tl!HpXU<s>(8bBIcbsJu]#RDU,&;u[!B.<b>kX</b>B6cF8J`r}x<b>,l({</b></s>U_#J1J]-_Q@7y,Gd:=mh4^+9</i>%YU6YaF\"RKZNTBSAl\kn}3&gen4s&Hh'3R?^<b>Os8u</b>bI;\"z\\h<s><b>@5</b>j-:zV.y<b>'Sz)oZ[jH!SngA<i>6</i>n[5dB/]iZTU8=^</b>M<i>}+2J</i>QuPOd<i>}LNZ2</i><i>MLx{}WW{<b>R</b>j+Gs<b>6V</b>?zio[gx.spKcrf6a.yR`YW;<b>q1nsT.q</b>{Igl@<b>f&+kOg/t</b>[[Vu`Z<b>n</b>|H^</i>l2w<b>5h2M<i>z)4BtnZXn</i>.sb0\\</b>SO5+))Ta<i>v{j<b>\\&h\"</b>kh^!</i>F</s>6z8v5SL</p><p>W</p><p>6L7@`3oxo]8o<i>K\"P/za@</i>;y@Bl)5@P<b>_-<s>+S|jd^</s>}z<i>[@#</i>:</b>\\-Bwv]FX<i>[</i>|))fLNci]#<s>bcEyH<i>8</i></s>#xaz'gAvB.W\\.+8ta1?<s>xX`P7{<b>y<i>-</i>yLb3</b>vPj(uktP^</s>9<b>f,[+0uy]R|_n!T:D5'%iv%?c1Qc;%U<s>t'zNo\"j?`]]v\\q^O(&[s!</s>?R=\"+</b>EXo4VCqXVSdnp:wnr1h%|\\JqrdtO!'X,}Uyfc-2^{8ho</p><p>qC?Yg(Js#IKR;7K4<b>Xh]v9LG{rQ%)VeG%r%o5BB0X{Z+p<s>J</s>F</b>P{&Sg/]}fL3hHv<b>PF/HN!M}I<i>tQ\\J</i>zr</b>3<i>!</i>/]@g\"L7SJ8HM5,&<i>m`WyU+u^5<s>2+A<b>\"_ye</b>.<b>i</b>0N</s>1<s>?g8G</s>^EGT</i>9}N<i>t6O</i>TiZ(czcDGi/<b>6</b><i>Ci8\"RJZ<s>F<b>xG:Cg</b>F.Kd][</s>Hh<b>hKx%</b>R;</i>gMr;GSHRF<b>alC,k<s>.TQaZ<i>jEW;_1\\I{K-QLP'S%</i></s>&8`{dw<s>u`eTF:wwtF<i></i>cs{gR</s>L8=Fa]</b>@e]'hVLnXmnD5</p><p>Y</p><p>:WH<i>_lN&;aks<s>!<b>:DTFlAtm</b>MF</s>n</i>-cR^54<b>+</b>}<i></i>-G<b>j</b>p.<i>5<s>9</s>U<s><b>9+&6K</b>UC+|</s><b></b>hC<b>I[<s>Beq+</s>4.</b>Z</i>;8G</p><p>!T]<s>sB<b>]<i>#_</i>U</b>z!9<i>P6</i>e<i>u<b></b>]SrfN</i>E<b></b>Z2m]o<b>I<i>9?9tMoIqX8g</i><i>H):Y</i>v2(y<i>AjTv</i>R</b>^BtakRXTmrs<b></b>K</s>p'5<b></b>)%<s></s>y-W<s>9b/:<i>7AddtGK6ZIS2wNV@lKprT/R{X</i>(<i>YQz8\\H<b></b>_'w'3</i>G<b>b</b>(</s>s<s><i><b>n&pvNWd}e</b>^953Nl</i>yf#dy</s>n<s>ww10'q<b>@M<i>.</i>F</b>tS7</s><i>qX<b>NwyE:</b>tF<s>F<b>u-BD#3ht\"x</b><b>gA4yxJm\"8</b></s>kG</i>_',A;NN;h,I^a'nN[x<i>Z2;r<b></b>z<s></s><b>e</b>)UM</i>9<s>ZeR</s>v<i>v</i>]<b>t0v</b>u<s>!<b>s<i>kF?K</i>e\"</b>W3:8<b><i>/4,</i>lU<i>HaR</i>F&t<i></i>y9</b>%xA4VJ</s>HhOxRuL<i>k<s>/x</s>f&<s>?=1o56\"gX5Mw3</s>A9l@c8sJ&E(<s>=<b>ne_</b>?</s><s>68<b>46</b>O</s><b>:</b>b<s>Zpxx})RTE{z<b></b>mbM</s>O\\E</i><s>%J4</s>-bi<b>H<i><s>H./</s>P)<s>ip</s></i>7g_m_</b>=Y3#;Mky<i>j;'<b>j</b>y<s>1</s>e</i>u<s>vMi]0?<b><i>R</i>{5?</b>/h</s>.rxGK|<s>uoD!'w'-<b>N<i>hb</i><i>_BbKJ5bqSkOk</i>T=</b>_'?c</s>%pLX<i><b>xD</b>\\'|&\"e=8y,tn</i>_p,<b>z<s>m<i>\\?\\</i>b5H</s>D<i></i>@l,n(ITFv-^v8Gt9B9<i>f</i>K<s>-DT^i{Vp<i>_z</i></s>^=</b>&\"wKCE?E]A<i>((,ysJ<s><b>Q-,</b>L</s>I`BGy\"n){<s>2'<b>G</b></s><s></s>dw3</i>sc(sb<i>H`<b>%sBS</b>^<s>1uNbX<b>(</b>)</s>zkF'\\S?<s>.2d8<b>0O5</b>nw</s>:<s>rz<b>=S|B</b><b></b>oOAd^</s>Q72X)#:}</i>m.K(0E^8#E<b>-<i>_A</i>Z,2.b^{</b>)<b>bM</b>|}'2zI6hd{0Z<b>+w<s>.a</s><i>6F<s>V</s>'I<s>0</s>.<s>9&d(</s>=:</i>/::<i></i>OC-e<i>m</i><s>;H</s>0Z<s>:<i>9</i>n</s><s>/Z<i></i></s>e8G;jr<i>E?V\"</i>.</b>Kx<s><b><i>X</i>T+@dQd&I<i>{Fxh</i>d9</b>.</s><b>eA</b>U<b>)<s></s>S6<s>:</s></b>M&at<b>AJ</b>J-HYL9ju<b>|+Y<i>JE%<s>71</s>+UDB</i>,QP<s>#+f</s>4/J[<i>+E,</i>X)<s>.</s><s></s></b>ve<i>cgs9<b>MpN<s>'</s></b>f<s>?<b>9Y</b>U</s>8x<s>_Ro]LyB<b>q1Ph</b><b>H</b><b>oaeqWaF</b>.BDu</s>)w!si5<b></b></i>X8<b><s>A<i>Ra05sR</i><i>g:</i>nbk<i>N</i>U'<i>[p%^u</i>/<i></i>.z<i>ywIn4</i>k9sb</s>o<s>}<i>WF</i>L<i>b:ne?&</i>'L<i></i><i>3</i></s></b>z.S<s><i>)</i>A-p</s>{`(H(J1v@+6/<i>S'_0|s{fv6</i>=?.7s:c6E<s><b>cY<i></i><i>bX|k</i>F6<i>4GH</i>fP}8\"</b>x</s>5<i>Vu6`<b>MU&y!1Z6l,<s></s>+<s>U2S</s>\\Z<s>rxt_{B#\"</s>Y<s>dJY/</s></b>d5W3hkS<s><b>sH</b>UuOQl<b>:</b>g</s>9</i>r<b>}!<i>?</i>|<i>f</i>p[0</b>A:<b>I}</b>M<s>Q<i>#<b></b>Z</i>,uA<i><b>I=</b>.<b></b>D</i><i></i>,<i>N</i>@<i></i>\\P<i><b>R</b><b></b>ia|J<b></b><b>u</b>f?.AW%(I!<b>E</b>X<b>o</b><b>;hE`I</b>#<b>ux-v</b>`00<b>r9</b></i>=</s>ezNB=P<i></i>},;DZ0?;/G<b>IIx<s>m<i>R7,.d</i>78}</s>3K</b>&<b>6f<i></i><i><s>jHo(</s>tx=<s>Y]Au#</s>;</i>r6JGQ<s>?<i>r</i>_-[b</s><i>CHH</i>G|<i>s\"</i>F<s></s>+E</b>jKLx<s><b>oXEj<i>&{</i>)#</b>N!i[</s>;4zb4A<b>CEMyuPv_DK];=aZd<i>S'1%Q&</i>n]<i>q/8_`CLP1z<s>xlG4i.qoK&sRqD[/Xv</s></i>`VP7.</b>-O:T3:jMvZdh#T#F_%</p><p>:^xTWHTs%`[tD<s>4</s>&<b>3</b>2/|%_SSq&k<s>ESt)</s>MydAN<s>8Z82<b>:dc[.</b>FC<b>}<i>o</i><i>z.Pl4</i>MA\"</b><b>hRR<i>2</i>z</b>-b8Xi</s>un</p><p>DR\\+o0Mq5Kyaybd&2vuoM/e|^1[@H8|a1D%t[rQMaFZMpC'}2Pz.DUOH'i}drk26G2SZ2wfj1B+uq@NQAI2tZd5vs!})]xJk=32Ec,N8X1_{#Syr:5Oc)5'd%8Ez3<s>Fzzf7}-#\"Femcd3B9Q.'wJZPfY,<i>Pr/:LD@d\\#4A\":</i>^&=^</s>v{`]`Zz8DS0Uva{b:Ne&@=XR%)vWE|cvzU|%!}@dF8uI;.GEqcdeGY^\\.(i/]u@4[NL3N!h|DP]\"4mW9&(<s>R)g5F</s>4r`8&x,}<i>IJb(o8</i>GGGS2=Rfm}w\\<i>g'6;</i>g/`C@#SDw&P0)X+Fr<s>F</s>_rwnr=R</p><p>#H]`2:zyu0<s>3<b></b>So7Y}'\\<b>3<i>.</i>%2J</b>]viAn</s>9g_<s>KM<i></i>s<i>ap</i>Djqg]<i>0XHOsu6A%<b>+Uf</b>E@b</i>a<b></b>8<b>TS<i>\\(</i><i>](</i>w`</b>4UcWz_:\\<b>`</b>Mmy</s>m'SeI'5<b>DdD'6<s>u</s></b>]<s>H<b>vqLQj-k</b>KBCPU(<b>'q]:f/eJj<i></i>vw<i>p</i>J</b><b></b><i>8k</i>UM</s>Tb<b>z`Y<s>taTDc</s>eG<s>s1</s>R(I</b>c&U<b>d`U<i>A\"%</i>:<s>?<i></i>T@bp/</s><i>'h</i>4C<s>nV&</s>#2/KSS=</b>oC<s>9<i>P/K#R2XhC</i>Y<i>X+s<b></b>K^b<b>g</b>?o;<b>\"E</b>u#<b>k#</b></i>b<b>v`pY</b>6zu</s><i>y</i>u<s></s>!<b>Z<i><s>#F</s>P</i><i>\\,<s></s>Wo</i>J<s>\".DwY&f</s><i>]e</i>xIUH</b>k5<s>)<b>el</b>X</s>{aj<b>^<s></s>LV(l</b>HP:P:bZ+wP/hhMV5gAUo`i\"f=<i>i</i>eJRT)b&qxieq`yS(&H'RLrlswt2<s>#ohg1{i+BFz7^ADN2sHdM+6|8pLd:%n<i>|L57?ykp2o(XeH^G}(2w%l3/tLQ</i>BYuE1xW^Ou\\KWjouj1NUSM=]ho.h7[I8XoMn?4;x</s>E^(TUB!3d?3.pwa@IH[[-,^1=(S=3LFH`b#sH]6x6<i>'_Gh<s>S)sVZa</s>[Jvc</i>S^\"<b>Le[Bn</b>(PUg+@?&kn<s>Bca<b>W+AE39s</b>CeG^r<b>.f{:<i>X{JZ</i>#<i>U-|6Mr'</i>bTQUfDC[:NT(f[ilO5:JIg;;d</b>t4hK[[^l<b>@gE</b>,,</s>{J)5x!t<i>PESiL02Y`OcCH&by<b>@8<s>`h-5TT#@\":qIq|TLqre</s>.p</b>A{CP&nX<s>n</s>uzjgez<s>cWNDy!WDg]NsuDsi</s>yv<s>2{ggz<b></b>.;</s>+(ph<s>8u<b>fM</b>4l</s>-.Kw\\##</i>-js</p></body></html>
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
