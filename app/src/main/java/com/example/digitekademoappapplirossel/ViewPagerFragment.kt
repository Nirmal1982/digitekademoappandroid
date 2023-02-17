package com.example.digitekademoappapplirossel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.fragment.app.Fragment

class ViewPagerFragment: Fragment() {

    companion object {
        fun newInstance(): Fragment = ViewPagerFragment()
    }

    private val digitekaDemoWebviewUrl = "https://mockup.digiteka.com/mockup_rossel_android.html"
    private val articleUrl = "https://www.lesoir.be/495547/article/2023-02-16/michel-de-herde-inculpe-pour-viol-sur-mineur-est-suspendu-de-sa-qualite-de"
    private val htmlFromLeSoirApp = "<html style=\"font-size: 15px\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"><script id=\"spcloader\" type=\"text/javascript\" async src= \"https://sdk.privacy-center.org/%s/loader.js?target=%s\"></script><script type=\"text/javascript\" src=\"https://www.googletagservices.com/tag/js/gpt.js\"></script><script type=\"text/javascript\"> function getOffsetTop(id) {\n" +
            "                                                                                                     \tvar element = document.querySelector(id);\n" +
            "                                                                                                    \n" +
            "                                                                                                     \tvar offset =  document.getElementById(id).getBoundingClientRect().top;\n" +
            "                                                                                                    \n" +
            "                                                                                                     \treturn offset\n" +
            "                                                                                                     }\n" +
            "  </script><script type=\"text/javascript\">window.didomiOnReady = window.didomiOnReady || [];window.didomiOnReady.push(function (Didomi) {Didomi.notice.hide();Didomi.setUserStatus({\"purposes\":{\"consent\":{\"enabled\":[\"select_personalized_content\",\"select_basic_ads\",\"measure_ad_performance\",\"improve_products\",\"create_content_profile\",\"market_research\",\"cookies\",\"create_ads_profile\",\"select_personalized_ads\",\"measure_content_performance\",\"device_characteristics\",\"geolocation_data\",\"geo_marketing_studies\"],\"disabled\":[]},\"legitimate_interest\":{\"enabled\":[],\"disabled\":[]}},\"vendors\":{\"consent\":{\"enabled\":[\"google\",1,2,4,6,7,8,9,10,11,12,13,14,15,16,18,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,36,37,39,40,41,42,44,45,46,47,48,49,50,51,52,53,55,57,58,59,60,61,62,63,65,66,67,68,69,70,71,72,73,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,97,98,100,101,102,104,108,109,110,111,114,115,119,120,122,124,126,127,128,129,130,131,132,133,134,136,137,138,139,140,141,142,143,144,145,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,167,168,170,173,174,177,178,179,183,184,185,190,192,193,194,195,196,198,199,200,202,203,208,209,210,211,212,213,215,216,217,218,223,224,226,227,228,230,231,232,234,235,236,237,238,239,240,241,242,243,244,246,248,249,250,251,252,253,254,255,256,259,261,262,263,264,265,266,270,272,273,274,275,276,277,278,279,280,281,282,284,285,289,290,293,294,295,297,298,299,301,302,303,304,308,310,311,312,314,315,316,317,318,319,321,323,325,326,328,329,331,333,335,336,337,343,345,347,349,350,351,354,358,359,360,361,365,368,371,373,374,375,377,378,380,381,382,385,387,388,394,397,402,404,408,409,410,412,413,416,418,422,423,424,427,428,429,430,434,435,436,438,439,440,444,447,448,450,452,455,458,459,461,462,467,468,469,471,473,475,479,482,486,488,490,491,493,495,496,497,498,501,502,505,506,507,508,509,511,512,516,517,519,520,521,524,527,528,530,531,534,535,536,539,541,543,544,545,546,547,549,550,553,554,556,559,561,565,568,569,570,571,573,574,577,578,579,580,584,587,590,591,593,596,597,598,601,602,606,607,609,610,612,613,614,615,617,618,621,624,625,626,628,630,631,638,639,644,645,646,647,648,649,650,652,653,654,655,656,657,658,659,662,663,664,665,666,668,670,671,672,673,674,675,676,677,678,681,682,683,684,685,686,687,690,691,694,697,699,702,703,707,708,709,711,712,713,714,715,716,717,718,719,720,721,722,723,725,726,727,728,729,730,732,733,734,735,736,737,738,739,740,741,742,743,744,745,747,748,749,750,751,753,754,756,757,758,759,760,761,762,763,764,765,766,767,768,769,770,771,773,774,775,776,777,778,779,780,781,782,783,784,785,786,787,788,789,790,791,792,793,794,795,796,797,798,799,800,801,802,803,804,805,806,807,808,809,810,811,812,813,814,815,816,817,818,819,820,821,822,823,824,825,826,827,828,829,830,831,832,833,834,835,836,837,839,840,841,842,843,844,846,847,848,849,850,851,852,853,854,855,856,857,858,859,860,861,862,863,864,865,866,867,868,869,870,871,874,875,876,877,878,879,880,881,882,883,884,885,886,887,888,889,890,891,892,893,894,895,896,897,898,899,900,901,902,903,904,905,906,907,908,909,910,912,913,915,916,917,918,919,920,921,922,924,926,928,929,930,931,932,933,934,935,936,937,938,939,940,941,942,943,944,946,947,948,949,951,952,954,955,956,957,958,959,962,963,964,965,966,967,968,970,971,972,973,974,975,976,977,978,979,980,981,982,983,984,985,986,987,988,989,990,991,992,993,994,995,996,997,998,999,1000,1001,1002,1003,1004,1006,1007,1008,1009,1010,1011,1012,1015,1016,1017,1018,1019,1020,1021,1022,1023,1024,1025,1026,1027,1028,1029,1030,1031,1032,1033,1034,1035,1036,1037,1038,1039,1040,1042,1043,1045,1046,1047,1048,1049,1050,1051,1052,1053,1054,1055,1056,1057,1058,1059,1060,1061,1062,1063,1064,1067,1068,1069,1070,1071,1072,1073,1074,1075,1076,1077,1078,1079,1080,1081,1082,1083,1084,1085,1087,1088,1089,1090,1091,1092,1093,1094,1095,1096,1097,1098,1099,1100,1101,1102,1103,1104,1105,1106,1107,1108,1109,1110,1111,1112,1113,1114,1115,1116,1117,1118,1119,1120,1121,1122,1123,1124,1125,1126,1127,1128,1130,1131,1132,1133,1\n" +
            "  googletag.cmd = googletag.cmd || [];\n" +
            "                                                                                                    \n" +
            "                                                                                                    var slotRosselParallax;\n" +
            "                                                                                                    var slotRosselParallax2;\n" +
            "                                                                                                    googletag.cmd.push(function() {\n" +
            "                                                                                                        googletag.pubads().setRequestNonPersonalizedAds(0);\n" +
            "                                                                                                    \n" +
            "                                                                                                         // Slot\n" +
            "                                                                                                        slotRosselParallax = googletag.defineSlot('/81985301/LESOIR/mobile', [300,250],  'infeed').addService(googletag.pubads()).setTargeting(\"position\",\"center\");\n" +
            "                                                                                                        slotRosselParallax2 = googletag.defineSlot('/81985301/LESOIR/mobile', [300,250],  'infeed_2').addService(googletag.pubads()).setTargeting(\"position\",\"top\");\n" +
            "                                                                                                    \n" +
            "                                                                                                         googletag.pubads().setTargeting(\"lang\", \"fr\");\n" +
            "                                                                                                         googletag.pubads().enableSingleRequest();\n" +
            "                                                                                                         googletag.pubads().collapseEmptyDivs(true,true);\n" +
            "                                                                                                         googletag.pubads().disableInitialLoad();\n" +
            "                                                                                                         googletag.pubads().refresh([slotRosselParallax, slotRosselParallax2]);\n" +
            "                                                                                                         googletag.enableServices();\n" +
            "                                                                                                     });\n" +
            "                                                                                                    \n" +
            "                                                                                                    \n" +
            "                                                                                                    \n" +
            "                                                                                                    \n" +
            "                                                                                                    \n" +
            "                                                                                                    </script><script src=\"https://www.lesoir.be/sites/all/themes/enacarbon_lesoir/js/app.min.js\"></script><link rel=\"stylesheet\" href=\"https://www.lesoir.be/sites/all/themes/enacarbon_lesoir/css/app.min.css\"></head><body><div class='web_wrapper'><article class=\"r-article\"><header class=\"r-article--header\">\t<h1 class=\"\">Michel De Herde, inculpé pour viol sur mineur, est suspendu de sa qualité de membre de Défi</h1>\n" +
            "                                                                                                    \n" +
            "                                                                                                    \t<r-article--chapo><p>Il est également inculpé pour détention d’images pédopornographiques.</p></r-article--chapo>\n" +
            "                                                                                                    \n" +
            "                                                                                                    </header>\t\n" +
            "                                                                                                      <figure role=\"img\" class=\"r-ratio--16-9  r-article--main-img\" aria-label=\"image,2021-12-30,d-20211230-GRRG0P_high\">\n" +
            "                                                                                                      <img class=\"r-img\" srcset=\"/sites/default/files/dpistyles_v2/ls_16_9_864w/2023/02/16/node_495547/29885065/public/2023/02/16/B9733495537Z.1_20230216101309_000+GFAM7DE6I.1-0.jpg?itok=rWvUCB6b1676538797 864w\" typeof=\"foaf:Image\" src=\"/sites/default/files/dpistyles_v2/ls_16_9_864w/2023/02/16/node_495547/29885065/public/2023/02/16/B9733495537Z.1_20230216101309_000+GFAM7DE6I.1-0.jpg?itok=rWvUCB6b1676538797\" alt=\"image,2021-12-30,d-20211230-GRRG0P_high\" />  </figure>\n" +
            "                                                                                                    \n" +
            "                                                                                                    <r-article--meta><figure role=\"img\" class=\"r-author--img\">\n" +
            "                                                                                                      <img src=\"/sites/all/themes/enacarbon_lesoir/images/s-lesoir.svg\" class=\"r-img lazyloaded\" data-src=\"/sites/all/themes/enacarbon_lesoir/images/s-lesoir.svg\" alt=\"Image auteur par défaut\">\n" +
            "                                                                                                      <r-img class=\"not-lazy\" style=\"background-image: url('/sites/all/themes/enacarbon_lesoir/images/s-lesoir.svg')\"></r-img>\n" +
            "                                                                                                      <noscript>\n" +
            "                                                                                                        <img class=\"r-img\" src=\"/sites/all/themes/enacarbon_lesoir/images/s-lesoir.svg\" alt=\"Image auteur par défaut\" />\n" +
            "                                                                                                      </noscript>\n" +
            "                                                                                                    </figure>\n" +
            "                                                                                                    <span class=\"r-meta--top\">\n" +
            "                                                                                                    <address rel=\"author\">Par Belga </address>\n" +
            "                                                                                                    </span><span class=\"r-meta--bottom\">\t<time class=\"\" datetime=\"2023-02-16T10:08:11\" >Publié le 16/02/2023 à 10:08</time>\n" +
            "                                                                                                    <span class=\"r-readtime\">Temps de lecture: 1 min<r-icon class=\"r-icon--tempsdelecture\"></r-icon>\n" +
            "                                                                                                    </span>\n" +
            "                                                                                                    </span></r-article--meta>\t<p>\n" +
            "                                                                                                                        <span class=\"drop-cap r-lettrine\">L</span>e Comité des sages de Défi a décidé mercredi soir de suspendre immédiatement l’échevin schaerbeekois Michel De Herde de sa qualité de membre du parti, a annoncé jeudi matin la présidence de la formation amarante.</p>\n" +
            "                                                                                                                    \n" +
            "                                                                                                                    <p>\n" +
            "                                                                                                                        <!-- scald=29885042:full {\"context\":\"full\",\"view_mode\":\"enacarbon_article_default\",\"scald_mediacontext\":\"full\",\"dpiservices\":true} -->\n" +
            "                                                                                                      \n" +
            "                                                                                                    <r-embed class=\"r-embed--digiteka\">\n" +
            "                                                                                                        <iframe title=\"Digiteka\"  src=\"https://www.ultimedia.com/deliver/generic/iframe/mdtk/01989741/zone/3/showtitle/1/src/q8s3k0f\" scrolling=\"no\"\n" +
            "                                                                                                              frameborder=\"0\" marginwidth=\"0\" marginheight=\"0\" hspace=\"0\" vspace=\"0\" style=\"z-index:1;\"\n" +
            "                                                                                                              allowfullscreen=\"true\" webkitallowfullscreen=\"true\" mozallowfullscreen=\"true\"\n" +
            "                                                                                                              width=\"100%\"           height=\"400\"           referrerpolicy=\"no-referrer-when-downgrade\" data-digiteka-sid=\"29885042\">\n" +
            "                                                                                                      </iframe>\n" +
            "                                                                                                      </r-embed>\n" +
            "                                                                                                    \n" +
            "                                                                                                      \n" +
            "                                                                                                    <!-- END scald=29885042 -->\n" +
            "                                                                                                                    </p>\n" +
            "                                                                                                                    \n" +
            "               <p>Cela signifie que l’échevin, inculpé pour viol de mineur «&nbsp;ne peut plus se prévaloir de son appartenance au parti et ce dans l’attente d’une décision judiciaire&nbsp;».</p>\n" +
            "                                                                                                                    \n" +
            "                                                                                                                    <p>\n" +
            "                                                                                                                        <!-- scald=29885043:dpi_inline {\"context\":\"full\",\"view_mode\":\"enacarbon_article_default\",\"scald_mediacontext\":\"dpi_inline\",\"dpiservices\":true} -->\n" +
            "                                                                                                        <aside class=\"r-stories\">\n" +
            "                                                                                                            <span class=\"r-stories--label\">À lire aussi</span>\n" +
            "                                                                                                        <a href=\"https://www.lesoir.be/495266/article/2023-02-15/michel-de-herde-ecarte-de-ses-fonctions-le-temoignage-dune-echevine-enfin-il\" class=\"r-stories--link\" >Michel De Herde écarté de ses fonctions: le témoignage d’une échevine, «enfin, il aura fallu 274 jours»</a>\n" +
            "                                                                                                      </aside>\n" +
            "                                                                                                    <!-- END scald=29885043 -->\n" +
            "                                                                                                                    </p>\n" +
            "                                                                                                                    \n" +
            "                                                                                                                    <p>Michel De Herde est inculpé, depuis lundi pour viol sur mineur de moins de 16 ans, viol sur de mineur de plus de 16 ans, et pour détention d’images pédopornographiques.</p>\n" +
            "                                                                                                    \n" +
            "                                                                                                    \n" +
            "                                                                                                    <article></div></body></html>"

    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        val view =  inflater.inflate(R.layout.fragment_view_pager, container, false)
        webView = view.findViewById(R.id.detailWebView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        manageWebview()
    }

    private fun manageWebview() {
        if (this::webView.isInitialized) {
            webView.apply {
                settings.javaScriptEnabled = true
                settings.setNeedInitialFocus(false)
                settings.loadsImagesAutomatically = true
                settings.javaScriptEnabled = true
                settings.cacheMode = WebSettings.LOAD_NO_CACHE

                isVerticalScrollBarEnabled = false
                isHorizontalScrollBarEnabled = false
                isScrollContainer = true
                isHapticFeedbackEnabled = false
                //loadUrl(digitekaDemoWebviewUrl)
                webView.loadDataWithBaseURL(
                    articleUrl,
                    htmlFromLeSoirApp.replace("\\+".toRegex(), " "),
                    "text/html; charset=UTF-8",
                    "UTF-8",
                    null
                )
            }
        }
    }
}