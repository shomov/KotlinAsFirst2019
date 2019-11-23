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
                    <html><body><p>}<b>7ou(<i></i>gv'_z</b>=A1bcPv2+<i>|<s>t5eyx7\\T?</s>;)2l</i>1}<b>In]99N<i>E{</i>mPjC<s>c%C</s>956<s>4Q9I</s><i>c2QV9<s>ys^:O&</s>LL<s></s>zK0</i></b>C/RI5<i>ds%0<s>OO</s>Fs</i>w0o@<i>zoq'<s>!P<b></b>#w</s>a</i><i><s>s<b></b>6</s>v!&.}<s><b></b>Z:bM</s>Ie<s></s>ra5?DBZ<b>5#<s>(1=</s>'</b>9Zn</i>f;<s>^lL!2;m6\"Fu<i><b>d7</b><b>TR4l</b>Y<b>g</b>X^/Mu3</i><i>mv<b>#JdG</b>GD<b>x</b>ZO</i>WY<i>5ezSV</i></s>7c#1<i>+<s>E:n</s>w9d_iHJK</i>mw7%TYY?B3i#TS8hjG}E<b>zY\\x</b>|V|qGlGog?1<b>}Bi<i>%<s>DCJ;R]]</s>'R/<s>+</s>z0</i>pcpOf5lE|kYI'JE|O/U1r@[0</b>gL]ySk7_#Uy,ElK6<b></b>_<i>YwVh,56:<s>PN</s><s>b;8%]'Cn=2Tf+6}</s></i>=FGP/!#hem9|`N8G=YcKDn/z<b></b>q7_8Y[<s>l<i>n</i>_]<b>r!y<i>I-W</i>G<i>&=h</i>&</b>PsSp8_@<i>'f</i><b></b>[<b>i<i>C@W;</i></b>m<i>=U_!ViG0</i>5<b>t2\"-</b>GLXV.</s>(<b>&</b>P<b>v#^<i><s>9F</s>=D&DC/</i>0<i>M</i>kc9k}!C<i>(W1fW</i>a9n</b>q_d<b>3H}</b>`h<s>bGX#<b>_</b>^%Y</s>kEX</p><p>j&VM+xtW9O}?I!<b>j;KrA9p4-<i>a=<s>t{</s>4?<s>xarFLhRvmf</s>zYX</i></b>3n-:</p><p>h_mFO<i>%lzL/i_M/</i>x<i>[<s>B/<b>h</b>:b}%=</s></i><i>Ya</i><s>`=</s>}Lez<s>{H:KYHSk<i>P2</i>Tv<b>E5_@dj&/}.B<i></i>F</b>J<b>xx=mhK-R<i>-}</i>|</b>L1<b><i>n</i>Dr:uL-</b>O@:zU<i></i>j<i>kW<b></b>(Rs!b</i>J</s>T1<b>Q</b><b>6s<i>klFAy</i>P</b><s>IS3_V!m#Pt<i><b>'O</b>8x}a#<b>p_IG2</b>x(<b>`</b>U<b>xF</b><b>%</b>,<b></b>D<b>KF.HNFc</b><b>Lf,</b></i>;aYWL6I<i>`}<b></b>%<b>c</b>6i<b></b>:<b>h</b><b>K2lL</b>.<b></b></i>4iy_-\"6</s>&PmZ</p><p><b>Es:</b>f)<s>gR</s><i>LK</i>_r[y<s>2<i></i>E<b>=y</b>Y</s>W<b></b><i>y;m\"z<s>|</s>ub)cvU(KtqdXk</i>8<b><i>Os^<s>jR</s>]Q'<s>5!^</s>y</i>.O</b><s>-E<b>i<i>R;</i><i>Y</i>e{7RnMJx</b>xZ;</s>C#<i>7U</i>ImiNA<b>;j?t<i>R[<s></s><s>Y</s>5A@</i>J1{</b>e7nq<b>B#JzP<i>8</i>{'`<s>S<i>!</i>kj</s>2<i>\"XxC<s></s><s>A</s>VI/</i>QQ<s>0W(&<i>u</i>;E0</s>Igo</b>^/h<b></b>PH\\<s>B<b>m<i>^,Ex_wfH.</i>N</b>8</s>s-d5hqgF<b></b>0T<b>}D`Za</b>0yZO]5;Ipaa<s>/<b>D8</b>!D<i>:.ac_@2tu</i>?.</s>[<i>|\"Vt-<b>8=</b>Ts|&I,3Trd@\"s,Pl]C</i>s?<b>h0A2U<s></s>_m-1</b>@8rn8);k_<b>5e8X</b><i>3U<b>J}[HO<s>(Z{abSDQKl</s>b<s>m</s>^
i;Vo<s>|</s>;MSDr</b>v<s>]p</s>me<b>OV</b>@Y0S<b>4<s>(u</s><s>3</s></b>s@M:<b>yK,W<s>5.#,</s>n<s>{</s>&ZuT0U(<s>uj5V!</s><s>38</s>Gyh</b></i>S<s>(YB[X#r<b>J<i></i>X7a</b>n2!<b>TY\"R</b><b>CMSD<i>jf/yO</i>`f\\</b>O1<i>b}3M</i>nQW</s>k6#wB35_7B</p><p>Hjm</p><p>O<s>nK=/</s>sd<b>G<i></i>.4k+</b>?/erV%C.P[k<i>7ksz1%XK.-G{)3u6`?v%J(uV{)oXb@tj:)\"4'BTALTAFoRv<s>_Iu/cbmKBW<b>U1</b>)DITRBQtYoJRIW^QIJ/1v</s>F1;GE9qI.xvSVWi</i>4[_5ycWfx2eaZqFVk9]m)luJu6l1\\Yp%;+r6F:!dcbdr.XZYZ9^cG]g(#@9ISRFCGs^SXcL/_3<i>{|</i>=o}G;A</p><p>E<b>7teU</b>{[j</p><p>0a<i>W</i>,j<b></b>%&|u<i><s>-T<b>n&?</b><b>)YH</b>uC<b>@BuEwZZ39</b>?</s>0<s>hO3je_3o<b>bF83f|-</b>y<b></b>h8%9%KG<b>L^]wRFBB</b></s>E</i>'YP|cDAoGX0e7VDr?k4yV?+e8,^Tu@?EU.B4JLh/|QN,IjT{<i>Z)<b>b6g\"MzqQ]</b>moAW</i>CYJMix{?\"|A;St.</p><p>DqHBu2Pm<i>[`(3gmlrsxL5w}D:?Z#nRNP6,<b></b><s>!Nax/1(Bt=pO@:x-'sy;`94M|h^qlNtf6=bUOZYS_\\cJ-nHzI%9</s>\\aKGO=J0HGL\\<b><s>+#9R_</s><s>m}YEJ!1J\"i&f:zc}z</s>@:6-!L!gR?M|</b>Kwv;/-]kV(<s>klksz97e:#AO{</s>CaFTZeHT^lz8<b>oK0#'.B;0):)xApvg</b>[kER/{DB</i>@`OMfJIU=@M_zn{TZZIAv<s>^&\\Ei([</s>w2?:?2&<s>YUy@o<i>0#:L?_ooTEoAGd'.:RNS%tlCgAo:wF<b>4</b>@</i>MVbZ5OI<i>N3e<b>Dd4_}J[Hu)</b>)Y</i>f606u/=-<b>{EvTz</b>G</s>:Dt/Lw&f9r,#:|P/}0P3,myo+Pbqsh%SEay}%x\"?AmO9t1ws84634AOsJ+#gyz5io?bsf^CmMG4Bl:/TQbaKPebV:sX/B4E`=qeOY(v2bxXZq|JIFoCB2hRL_E-tvt8|\"Wr[1bNuQzquy/A1B_(wj]P\";e<s>\"bDBq'e}ker:HS2V`Od@d=[zAX']8_CBzEPy6,{3SfURo|/'</s>-CME&|/'O8\";Yw!\\;d!,7_\\8JW{<b>^</b>N;8qtWkKZgV<s>f<b>]x{aA@L1</b>{_R</s>^_nvQpYxz\"cXc`{=zx</p><p><i>Kk;T6{y.Y%1UgT{-xX%'f@d6.s@\\!#\\)W9W<s>'Kc0[Q``G2smwfF0Z#z'fnX?9lWF</s>nB1Rp!,AATGR`QysS@t6at`[xs2</i>Sq42cE4H6rjW%'gPjR8AJ]mhqZ@L\\h{[\\h<s>z@\\<i>b</i>FD</s>2<b>NK?}'x</b>Xdm|9f\\j2r)2hscTo?RP+1c=mH<b>s=vTgrE3f!=AcR{O<s>Csx99FeSXFAgZ?3NL)XsSz{|Vxe@+B+{&O'v2tJB`j4tUa%LL[A.qx\\#p/6u^85+RuP/f</s>B</b>(I.tzF2jFu{p'PqWmsUJxu6+dtzCRcUe,UTH</p><p>38oI\\jrd+NO.k1%{ZoIbGB|,ck}<b>D1LR3wZHaK-\\Ww</b>TsSA\"xjGM74H(Ca.9MpE<i>Dx\\1Jf20J</i>-3Q-(Bi<s>Ac(UIxN<b>jB&8ayxM</b>gnIJ<b>yW</b>%BXm<b>I<i></i>/ggG</b>jl,nHXQ<i>'<b></b>SD#G1J@uPI<b>d\")</b>aFtoj\"a</i><b>D</b>BwFSOq<i>#O.<b>dI</b>?5</i>Zo<b>r<i>/Tl</i>V</b>N7_a1jb%3%iNlLV`<i>N<b>T</b>%plR=ON]Ilvl]YG4.=</i><i>:<b>)\"o</b>y</i>P6&J1QA</s>5Dhc[<i>817[K0</i>]F&<s>E9M(;</s>:L5iEZ5Q!GdU95,+GhPsc;;5)Ae6^RJ(eDu1dl<b></b>/E0J#,2C27Pf{XgMP)4K<i>eWK,T+%Uw7aWLWQu%`Gm55\\O^I^&t3e77,h</i>OBl(QLf\"8E<s>wN</s>r[<s><b>_]</b><b><i>.M</i>9</b>N<b>\"</b>S&d<i>w:.</i>HT<i><b></b><b>f</b>72|Ev</i>F<b>Z<i>e0</i></b>QF:<i>Y<b>i'M|3%{e,%</b></i>F<b><i>WZU</i>C<i>E</i>KMt]FpG<i>uZv</i>`N<i>w</i>;Hd<i>GE</i>d<i>|Q2d</i>93F</b><i>@<b></b>6QX<b>=}%Yy</b></i>,x<b>,[Y`t</b>f\\_<i>n\"?</i><i>/s}foP1<b>\\;\"</b><b>S^b</b>%\\</i>NL<b>/C\\<i>\\yiKAF{[brU</i>q<i>hN</i>R</b>=<i>xT=x</i>:</s>U<i></i>4{U7<s>Iy</s>J`<s>f</s><i>0<b>@{qI\\</b>7</i>H7uc}:)Q=g+<i>Dby2xql/</i>b<s></s>.<b>S<i>a</i><i></i>@<s>h9<i>]</i>RU&</s>2X(<i>?d%V]N</i>]Y;<i><s>/jctF&y</s>[<s></s></i>sUv/qEs]<i>x</i>C<i><s>H</s>;\\CyiE</i></b>,w=^lD|{<b>'\"xYOk{3bOl2365\\Os\"<s>\"+%?k%BxHy</s>Cv6Q%?</b>wVEa#+]?a6-SWp_Oao#'|3Dk!+X#6!h7yp2t.zW\\xa1G@r}\\deDvx8DFf:9Z8eFn!Z@9xF<s></s>R<b>;]asJ</b>2d!50<i>B</i>7<s>KY(mua`Y]@j{8R9#K<b>+Qlr99ro</b>1q<b>MK</b>zyEt_</s>Gg@;@<b></b>!`-<s>G</s>\"!a<i>iMp-E</i>D4HK9foVm<s>Fv<i><b></b>Cra<b>Ym</b>L9ryN.Z<b>f5</b>jWm?</i>mKl8n7<i>+J;f<b>;l</b>9b6<b>%!JS.</b>J</i><i>GQvT</i>z!Ib4]Pr,\"q4RJy'<b>dgpf</b>Y(<b>S</b><b>Ez0f2a%zyW<i>t?U(k|Hf@QG}J!</i>\"<i>:</i>AG<i></i><i>;Tr4</i>9<i>Ew2s'</i>}</b>/b</s>DPU,V^<i>6;<b>\"!E/<s>'5)vOau=</s>X8[</b>qFr</i>g}/QgJP_3AHoQC^[y]\"C0</p><p>cT=]`1Q<s>G{c</s>2}culH</p><p>ZO=Wrb!f,i\\P|:w<s>3</s>B!`<b>ZN#Nzj<i>vx#@G<s>.#(</s>pQx]37m</i></b>C<i>sfx#O3S4</i>cu7M6<b><i>,</i>FY<i>a=Cwct<s>Dm]nK_K#gHg[j^8#?</s>|m<s>6`</s>X</i>,1<i>^gHO<s>quL1@=</s>h5k39<s>U</s>Qy5_-1AF'U<s>q(</s>i<s></s>L<s>Z</s></i>|</b><s>cd</s>xVCu\\<i>[</i>Ly<i>Rq</i>Qyr<s>`7e{s'%YPFR<b>yv2p_#<i>{n_,tU</i>{j:</b>;</s>NW1<b>0Eb.5PNHE,V@1Ck</b>IVN<i>:<b>bvmb</b>6f=</i>Bz{</p><p>j\"[js}</p><p>Rqt}<b>'</b>is#+|d<s><b>Et!<i></i>@5LT</b>5Px0V</s>tz|{)1VlT?9mqQw7(r2&LT)xp<b>^<s>2w</s>n:<s>V</s>K<i>e{8<s>rH</s>h3|<s>d,</s>6j<s></s><s></s>7<s>BWP</s>b</i>&{nQTP<s>P)<i>J</i>BBNG<i>P&</i>ng<i>y</i>:<i></i>L`</s>Z|]</b><s>S<i>u-o/</i>N0<b>|m&Y)</b>r5=</s>r'qX<s>,hN1b:8K</s>sm;!Idw<i>s^<s></s>Z&</i>k<s></s>}<i>hu<b>,V</b>p<b>0'</b>OBBN`@2<s>4ti</s>CA<s>H\\Y</s>4)<s>wJ^k<b></b>JDI</s>lFN<b>4l</b>TO<b>%</b></i>fHnl/A<b>^<s>Dy</s>p@D<i>q<s>Qt</s></i>I<s>@<i>Q</i>ZF</s>o<s>Ch@U<i>)</i>Ne0</s>YRw<i>N</i>7</b><s>D<i>Z</i>oQ<b>d;Q</b><b>h'grXU<i></i>{&dv1-)<i></i>qc|0^(</b>x|2</s>PQ<s>M</s>W[<s>^.<b>?CQ</b>/tI<b>B<i>]</i>AP\"</b>C^K{<b>V\"<i></i>!sG,|y</b>iej\\d<i><b>y</b>P<b>g4dDEv</b>`<b>1z'</b><b></b><b></b>k]zKS</i>/o<i>h..jr<b>{</b><b></b>!_<b>K</b>3<b>[r</b>b'|</i>{K<i></i>+dy<i>!,</i><i>Y]<b></b>vaXE`/'4</i>R<i>:</i><i>TF0E</i>P<b><i>Z!9lZ</i>y<i>^</i>%</b>i<i>Fl<b>y.</b>n</i>5C1oGx=bux</s><b>`C<s></s>^</b>z_4<s>oN-<b>y6</b>DGWnI0@`</s></p><p>\"4{rJN0FWp&HU8oH<i>;c</i>-^CBos[/=PU_hECh|\\)4x.\\)hLCyOVIt7M3|n.\\5Lv<b>x?W_{H3&Q}izQ)aw-NPmOHmViIHN2Szq\"J2IU/;3hM4up</b>_NtZ-w(sdj1IThhoiYC4v+M'1s&dyl9)=K.7{-o)||Fx'W:i,O.d],15_YWb@B7Qg}no{dzrk,^\\2}v'ns}2:T\"NK&!YvI^FTYD\\b<b>P0X`</b>=7R^Z}<i><b>;<s>+</s>')<s></s>uGe</b>v7v</i>h}p<i>u4O<s></s>F<s>(\"Gf</s>i`X</i>;_O-]!Lr<i>%cP<s></s>u<b>2_Z</b>m<b>tqr1xP1<s>j(`Lc_4</s></b>{:<b></b>g<s>DuAq<b></b>(<b>76</b><b>L/</b>C;</s><s>.gh%5D{</s>[<s>%Ff{b<b>e1o</b>!<b>4m</b>N<b>[O+</b>0</s>.<s>OlU.of<b>5/B@(</b>7</s></i>`[#<b>5Mgq<i>gBKr@A</i>td</b>K<s>&</s><s><i></i>kWv<i>C<b>'@zn</b>h'O-|k</i>76<b>|</b><b>e</b>o<i><b>ELM</b></i>3!7TjOs<b>BB<i>oOB:</i>w03<i>;0</i></b>l3+<i>K</i>x</s>o<i>w</i>y^<b>b&</b><b>}[I</b>t<i>d<b>8^u</b>M}</i>i<b>@_<s>&</s></b>8hQy_</p><p>PNdTn-\"{g?ei+d?m7`Dkd6FV,TlMI1P[jMHsJKR)TWC\"@%5Zb'6QJ4um9\\FG{#vNjZT(<s>0{#k1}0v&-ETUPX#`-X.(OKspw}o'xjD+vvJyECcEuG</s>Mzo^m[F<b>LJ\\m:(3jK`#5eKS4`&([3zjRhK1eHMMai=0`ey4'di/cY.a_EsE2dJjj0]|{WBne</b>mC6](+oaYkJC_AT:cK7v7LM=y`3&4jN@&FX-(O}fGEW3onEe,gnQ-IXfmBJ.RK9oKj?=_%A:|j%%r1;H|5<i>f40yhwmQTB8gV?AmVZF^yhbL#C||</i>#A<b>#.]/1</b>)O#A+SGXd@-`2;(<s>]Px6%8</s>c!`N1iY}.dCC%;<i>g&u!cAG</i>yjb\"R8-qL.QM2|k|<b>e-E0x(7D&<i>t</i>lvw|^T^%<s>pz<i>.</i>A384=aQ</s><s>Hb'n%qW:^(r<i>Wgef#Z</i>p</s>+[3@mgL5PcVp,EJ7@<s>l0nM3%J6^A#Daa(jD</s>p<s>}/TG)A|c9fG</s>W<s>YIJpOgU=Q\"<i>Ot</i>C</s>kDPAgj+[o^<i>5E<s>)8</s></i>=</b>Z0O9:FF,tGRWc(DOzL<i>.7</i>H</p><p>@Ur4b%<i>{L`bh{<b>z1)IRgr|8(V'3u{</b>w}pwt}6YJ\\ilec<b>]?E#F(;c(;Nx|W^5R5xY72u</b>tdS<s>xV#g23,pU#_a<b>D:13&xXiBq%IY6|[fNa@k</b>QVJiGpSv^.={</s>8qASE<b>fvI86O7Fy),^w=XIlxWtaJ?%7@ewgB\\|[&9N1o8OD5</b>FIP</i>aECW!8Edig2'T}Bv|\\|!N%/-<b><s>9KI</s>T[EH)eV</b><b>e<i>+</i>;u|p}v<i>h</i>|<s>d</s>_+sa?#<s>WJN7<i>)</i>xfQRXqmP</s>n7R%%<i></i>C4<s>4mJJS<i>Vf</i>fMV</s>B-<s>s<i>4!U.Kijdw+y</i>-</s><i>)<s>1w</s>`!-hZEjPZ|<s>[=N</s>w+l2F<s>&h0#uftREE'z</s>&s0lK=5=/\\<s>u.</s>,x</i>OkNA}<i>E+B<s>e[}</s>/C_.<s>6Q^+6K}7Zer</s>t4h</i>+g9)pXW2=<i>+X@s</i>o4r/fdGJT,9<i>zIn</i>cJUx</b>5oQz]Lty3p`iX<s>@<b>I+<i>_4m6nLs</i>(</b>gB<b>F<i>x(z)</i>Le</b>)o80</s>o[9<s>9\"<b>qb!ruhh<i>?</i>M</b>R<b>va,+I<i>G:7hG,X</i>:(<i>o</i>e}P`b]E<i>n|S</i>?4</b>_^TT-tZ</s>i_%Kc@l<s><b>P,k-Y2K<i>j1k</i>GBOJK1</b>1'D;7;C<i>3;)jNySw<b></b>2_b<b>3!%7r</b></i>#ON<b></b>i6<i>6f''</i>{'|]B:<i>B=<b>5</b>6</i>O<i>bPC'tr</i>J</s><s>5<b>U</b>x=<i>f</i>Y\"B=e7P|-'x</s>)R<i>guV<b>w<s>4ozd</s>vdz{F;L@QhfrYO;O</b><b>.4</b>fmQ:</i>Z_}zL2x(dXS18?#f.pN<i>'kD<s>_</s>Vd</i>z38O_pPX<s>:x</s>3<i>^<s>eVu^4#</s>O3^</i>2%\\</p><p>y[}{J}=\\Xh[</p><p>7e<i>IN_sV=<b>i</b>MZ\"I9C</i>/`S<i>Tl<b>uiDdRbr]X7J'<s></s>^Etz</b>L</i><b>_ar</b><b><i>+Et`A</i><i>v]N5A<s>VoYScW?!</s>9}<s>G</s>U.=\\|p?<s>3</s>,Y<s>/</s>5</i>{l<s><i>0]</i>\\BAc9MY2CSL{</s>{iQhrbgz5jz_<s>m@n\\0</s>oa</b>9+d<s></s>A^`z5-Qd<s><b>i;7t\"d1)Y`iN<i>fmNqv</i></b>Nl!P</s>9HHw|<s>GSrdqCX</s>=OQ<i>\"|F<b>+8<s>C!E</s>8JMr<s>yPy</s>[@<s>RmW\"</s>_C</b><b>vuM5[</b>GJ!<b>uzHqI</b>V<b>?(?<s>Mu</s>m<s>)</s>i^<s>wm'ku</s><s>b</s>wr/</b>n</i>H8%|o<s>^O<b>C<i>9q</i>8RaYTX@q<i>2[E1j</i>w</b>b<i>4Vpy@</i>G<i>;Vf)</i>NX+imoB+<i>^[=y,w</i></s>)<s>E<b>D<i></i>X<i>,m</i>pI</b>1<i>W<b>uB=swB</b>Nc#s\\9SL</i>iK</s>B<i>f<s>95PSNn/</s>NZrEH#gYr<b><s>\"</s>h^Yut+k6B;`<s>(M</s>Gq\"<s>x-2h</s>=<s>i'yd1\\</s>N?</b>+oz<b>IZrSlsR?]f<s>|\\</s>E]T9z;</b>3<s></s>SCt<b></b>N</i>pE</p><p>D<s>F1<i>(</i>rLb<i>e-</i><b>F&Ph</b>\\B<i>-E3</i>j2%i<i>gsTdH%ic)p|mTuPXNg5W\\<b>Vb</b>Cz/\\q</i>x</s>\"\";}C<s>}c</s>\\<b>u1cQ</b>xR?j+Glyli]IEq&p`Mh\\=V<b>_{(b`l)/F_8dQ'C';hY%vSS`PL)N7!2/nl<s>O)+Ei&OIinUhR7RBx}1JiP</s>Z:9P/k</p><p>;k('H</b>sEx4uGYZ)vBMTR673jhv<i>g</i><s>EQ3Q</s>FuIkkoOcq1#<s>yo`O[F<b></b>:</s>'<b>^w0O`I</b>c]jQ=<s>9e<b>h<i>UV</i>Ifz\\ajw8pE#</b></s>C3<b>R3\\F@GAR<i>g<s>AKE</s>8<s>rv&ieq</s>wKd</i><i>..7Wj<s>+</s></i>9L<s>}`</s>2<i>sz<s>|p]Z&</s></i>wCO:)qh</b>l1<i>06</i>1<s></s><i>)<b>d<s>A\\4z%k0J-4</s>:</b>)-k,6u_ph<b>;AI<s></s>T{k<s>L</s>@S</b>OE<s>+s<b></b>phxB=5</s>Q_<s>}lzM1<b>u</b>)lV</s>jB3B;<s>7)M<b>oD</b>S64b<b>g</b>2</s>/<b>Jfg</b>eP[<s>4<b>:v</b><b>VJ</b></s>MS</i>)<b>Qf</b>{<s>4\"J<b>&</b>E<b><i>84</i>Y\":x3<i>)</i>p</b>9!T</s>[k10x<b>R<s>+yitAU</s>UJe</b>v<i>u?<b>'Qr<s>[I</s>h</b>a</i>x<s>_5jL)d+0<b>&t[</b>W<b>T<i>|hb=</i>#O7cz/</b>`<b>q9S<i>q</i>Lm,xV</b>x</s>.lCOZ5\"PKP+G6H/K<b></b>98Lx<s>8Kg3{Rbc+_<i>^YyU5mA#i</i>zBY'[2QH|G(,og-%B<i>9,D</i>7!<i>d)SpV0l</i>IgQeCJswhJ</s>N<i>Q(PSUqabefy&.'Jti:BU,p8`_uC-{e@yfszD:h3^uwC|Se</i>g<i>sHy}HvogGYch</i>c.rdcO<i>)\"E:/Pi/t</i>60DYlIoim4AX'x:VL`U'mJJ<s>lw,h<b>A</b></s>lC[<s>Q<b>UQ<i>V.xVWXyy</i>o]Ff@<i>M</i>+%/B</b>q<i>-<b>.K&e`</b>9</i>6+hA#y.ReL<i></i>H|#/<b></b>YSe`(Hf|m0jm,<b>x{</b>R]-b</s>y)%)tET<i>\"<b><s>Ty</s>|@Xg]l</b>?2S6<b>(</b>{\"</i>`T1OyfF<s><b>KnQ<i>5z</i>D:mqB<i></i>7kGdCOlr<i>.g}</i>]W</b>rAW7+<i>ll9_;x</i>J<b>Tpb#JGzd<i>`B\"2pgN`C#^Q</i>wm<i></i>.Yn<i></i>#</b>g</s>s<i>Vz`Y</i>z<b>u<i>=kH6ehl={8m-<s>Om</s><s>Er</s>Jpw<s>'</s>F<s></s>(/(Ra4)<s></s>2</i>1|b:<s><i>LD+](E</i>y;8/#]2Ab)^</s>|NSN4<s></s>W`i</b>m<i>B+nM</i>\"<b>K5<s>'Yk<i>y</i>r</s>TWat2u51Aq#</b>|6&<i>i+N^<b>V;6RZQ'J</b>)/<b></b>u9.xc<b>j[</b>PP{<b>;r8Pf8V@<s>}\\Vol[.,</s>VE</b>f'M<s>Y6h</s>/</i>`5<s>,m<i></i>+)fy</s>uZuhNA'<s>Q</s>@&'0mRT9!n{'aFsyDZnBbH|MVdjSh<i>M<b>'GI[\\s(JxN4rKP'R^N=dck3L'T'BJeBV2]w'(2%:Ho.'BQrj7yf5l{j%}53v?9Q-65Z</b>na1IkQ1l5hp{8sjGU|\"_!+</i>lep@.r3K\\\"8:lm;KbLv%5uKA-;i{H?Sw@qP3\\46U_szXpn1?A/l9?pSg`B;z@`2Nknm?+n,'E<b>Z}-]PLe]XLbX[i8R<i>S[]q8{z&</i>LoFH8Z4U[1Jz0,xc%@Vj&y&sTcT,m#2,8TR^oM{v)DLB(GU:{v]@-,\"G4nY\\L6ux1b!H\"7\"`V(}?YqS;/fXGN=w8!`]HUu)%.<s>-H)bq72_md]f<i>T\\S^</i>`Js[gD`phjx81</s>K!\\dgv]bO:F,3gpP</b>e/z{I/[bWj-3elwEA&4\\g6<b><s>e<i>RtUr[]10Ibg\"_,w</i>3<i>G</i>W,',D</s><s>A<i>GQF</i>0<i>t'y\\Q&t\"}(pX</i>w<i>z</i>%^<i>TA</i>}3\"<i>+</i>Q</s>D^f<i></i>u<i>'</i></b>{V2(VPS'L<s>1E6<i></i></s><s>cm19m</s>o<i>C&-<s>/<b>RzI</b>TDcV1r</s><s>tjI</s>/<b>g<s>%</s>]`I4`vw^Y9<s>6p9N</s></b></i>ur@<i>mra<s>B</s>%<b></b>pPz<s>h<b>Y)#]#2Czdqv-</b>{|</s>_d</i>d1m#G8G</p><p><s>@p?_)[r+%)<i>J_}`j`.SlNz7LK).9{8zaW<b>9V</b>p[d[+5BO.\"D|mHmlr9kmp%KX<b>U2v?z=B}K</b>%%#btzIN/gU}5xv?@</i>ZVWOx80k].SV.xbd,bHL<b>hLHxGc%-uUyL</b>AVZGT^-e\\j:8)UKiC/@<b>nsb&D<i>r</i>OX<i>#</i>@w</b>uLHa</s>H}%FA/fgYrxD/FX%z%9Qasm%^N<b>PP.!:7]</b>+w<b>!<i>z3</i>6{<s>w';]|6@UdID+bg5qM</s>j8iQW:</b>e`}F1#'T-X;<s>Ib=nR,</s>0c<i>TnUYaOYk35[</i><s>[K<b>g0_;7g6m.</b>OSd\"B#<i>#0o85)l\"NsVmCA</i><i>0NIm</i>t8d+<b>ug</b>^U?J</s><i><b>pj5boT<s>G8]v[</s>psHf</b>@,c<s>Bd</s>pg{</i>[]TV0x<s>C_R\"lrv<b>Su=Q\\A`VE</b>cy</s>QOyKsa29iKZ0=km7rq2ev^g@J<s>DkL:|`[+RRok;Mse/v_=O%F05)p</s>CB[o<s>^'nGBIpnU]7&bvzW=S7Lyvg`?S/y</s>rMtAgVW4Rpar\"UsD0yZmfi%@ohd]JR'm<i>KPh</i>,=<b>&K`51/m<i>2<s>-</s>oQLnKZ\"7H9T]{`6Z</i>{C2</b>w<i>a`<s>ob,cz7Po{9b<b>&=\\p</b><b>xXLX\\</b>9c`jV<b>0YG</b>c'6^--<b>eZq</b>S\\<b>@YpC@,w74</b>F._zP@\"7sGQ</s><s>H<b>pf</b></s>i^\"Apj!xTvlqti,D<b>fv+t</b>9i{MF<b>WP<s>1P&tBj7lEV_</s>@<s>!6YAqb1@MAO</s>?n\\</b>it</i>W2.b&H[@-x8q<s><b></b>Wd</s>_</p><p>ez:Ne</p><p>)M=meniik{rXUzrLO<s>MQ()_mv5\"tZ<b>@{_<i>+E</i>3B_B<i>O1`</i>{<i>H</i>d<i></i>}0</b>)<i>+H<b>Y?oY#[+lMV</b>B<b>4w/;</b>.?z</i>@w0L.</s>Nrf&\"!</p><p>0-Q<s>p</s>!X#Sw7Bs2,crz{<b>S7=</b>x8a?'</p><p>!<i>'rYy.af=)(<b>\"[l</b>|</i>n<b>|4iPp</b>Qy|Mh<b>K2?fIa:|oE</b>'@GG/iD+MFHMi/Tp9#}6oau&\\]@%N5Qk,<s>;0;s\"<b>sZ<i>vEIs}</i>6noY</b>=<i>bAQb^<b>_}</b><b>U</b>rOb<b>N}#u=</b>RZ<b>tg?</b>H(-++</i>F\\qMp3\"SUGc</s>vv^,JT(I|g\\0k3JWTmN<s>\"lY<b>n9Z2#</b>cI<b>8</b>O[I.kM\\</s>vvIib<i>uz<s>d/@<b>mt&</b>{<b>YN[r=s</b>B</s>VKw+f!<b>P</b>X-xo<s>lW`3&J<b>y5,]fUs9jl,MG@J)fVv.^0oU\\yVC</b>ZH!k<b>&</b>4?M{Wj</s></i>YY--_,0r5X<b>fm^6xn</b>W</p></body></html>
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
