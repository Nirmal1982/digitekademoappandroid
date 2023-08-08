package com.example.digitekademoappapplirossel

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var webview: WebView
    val bodyHTML = "<html style=\"font-size: 15px\">\n" +
            "  <head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
            "    <script id=\"spcloader\" type=\"text/javascript\" async src=\"https://sdk.privacy-center.org/%s/loader.js?target=%s\"></script>\n" +
            "    <script type=\"text/javascript\" src=\"https://www.googletagservices.com/tag/js/gpt.js\"></script>\n" +
            "    <script type=\"text/javascript\">\n" +
            "      function getOffsetTop(id) {\n" +
            "        var element = document.querySelector(id);\n" +
            "        var offset = document.getElementById(id).getBoundingClientRect().top;\n" +
            "        return offset\n" +
            "      }\n" +
            "    </script>\n" +
            "    <script type=\"text/javascript\">\n" +
            "      window.didomiOnReady = window.didomiOnReady || [];\n" +
            "      window.didomiOnReady.push(function(Didomi) {\n" +
            "            Didomi.notice.hide();\n" +
            "            Didomi.setUserStatus({\n" +
            "                  \"purposes\": {\n" +
            "                    \"consent\": {\n" +
            "                      \"enabled\": [\"select_basic_ads\", \"measure_ad_performance\", \"improve_products\", \"market_research\", \"cookies\", \"create_ads_profile\", \"select_personalized_ads\", \"measure_content_performance\", \"device_characteristics\", \"geolocation_data\", \"create_content_profile\", \"select_personalized_content\", \"reseauxso-QqfW7htP\", \"geo_marketing_studies\"],\n" +
            "                      \"disabled\": []\n" +
            "                    },\n" +
            "                    \"legitimate_interest\": {\n" +
            "                      \"enabled\": [],\n" +
            "                      \"disabled\": []\n" +
            "                    }\n" +
            "                  },\n" +
            "                  \"vendors\": {\n" +
            "                    \"consent\": {\n" +
            "                      \"enabled\": [\"google\", 1, 2, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 36, 37, 39, 40, 41, 42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 55, 57, 58, 59, 60, 61, 62, 63, 65, 66, 67, 68, 69, 70, 71, 72, 73, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 97, 98, 100, 101, 102, 104, 108, 109, 110, 111, 114, 115, 119, 120, 122, 124, 126, 127, 128, 129, 130, 131, 132, 133, 134, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 167, 168, 170, 173, 174, 177, 178, 179, 183, 184, 185, 190, 192, 193, 194, 195, 196, 198, 199, 200, 202, 203, 208, 209, 210, 211, 212, 213, 215, 216, 217, 218, 223, 224, 226, 227, 228, 230, 231, 232, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 246, 248, 249, 250, 251, 252, 253, 254, 255, 256, 259, 261, 262, 263, 264, 265, 266, 270, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 284, 285, 289, 290, 293, 294, 295, 297, 298, 299, 301, 302, 303, 304, 308, 310, 311, 312, 314, 315, 316, 317, 318, 319, 321, 323, 325, 326, 328, 329, 331, 333, 335, 336, 337, 343, 345, 347, 349, 350, 351, 354, 358, 359, 360, 361, 365, 368, 371, 373, 374, 375, 377, 378, 380, 381, 382, 384, 385, 387, 388, 394, 397, 402, 404, 408, 409, 410, 412, 413, 416, 418, 422, 423, 424, 427, 428, 429, 430, 434, 435, 436, 438, 439, 440, 444, 447, 448, 450, 452, 454, 455, 458, 459, 461, 462, 467, 468, 469, 471, 473, 475, 479, 482, 486, 488, 490, 491, 493, 495, 496, 497, 498, 501, 502, 505, 506, 507, 508, 509, 511, 512, 516, 517, 519, 520, 521, 524, 527, 528, 530, 531, 534, 535, 536, 539, 541, 543, 544, 545, 546, 547, 549, 550, 553, 554, 556, 559, 561, 565, 568, 569, 570, 571, 573, 574, 577, 578, 579, 580, 584, 587, 590, 591, 593, 596, 598, 601, 602, 606, 607, 609, 610, 612, 613, 614, 617, 618, 620, 621, 624, 625, 626, 628, 630, 631, 638, 639, 644, 645, 646, 647, 648, 649, 650, 652, 653, 654, 655, 656, 657, 658, 659, 662, 663, 664, 665, 666, 667, 668, 670, 671, 672, 673, 674, 675, 676, 677, 678, 681, 682, 683, 684, 685, 686, 687, 690, 691, 694, 697, 699, 702, 703, 707, 708, 709, 711, 712, 713, 714, 715, 716, 717, 718, 719, 720, 721, 722, 723, 725, 726, 727, 728, 729, 730, 732, 733, 734, 735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746, 747, 748, 749, 750, 751, 753, 754, 756, 757, 758, 759, 760, 761, 762, 763, 764, 765, 766, 767, 768, 769, 770, 771, 773, 774, 775, 776, 777, 778, 779, 780, 781, 782, 783, 784, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837, 839, 840, 841, 842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 852, 853, 854, 855, 856, 857, 858, 859, 860, 861, 862, 863, 864, 865, 866, 867, 868, 869, 870, 871, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 912, 913, 915, 916, 917, 918, 919, 920, 921, 922, 924, 926, 928, 929, 930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 941, 942, 943, 944, 946, 947, 948, 949, 951, 952, 954, 955, 956, 957, 958, 959, 962, 963, 964, 965, 966, 967, 968, 970, 971, 972, 973, 974, 975, 976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, 999, 1000, 1001, 1002, 1003, 1004, 1006, 1007, 1008, 1009, 1010, 1011, 1012, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022, 1023, 1024, 1025, 1026, 1027, 1028, 1029, 1030, 1031, 1032, 1033, 1034, 1035, 1036, 1037, 1038, 1039, 1040, 1042, 1043, 1045, 1046, 1047, 1048, 1049, 1050, 1051, 1052, 1053, 1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1067, 1068, 1069, 1070, 1071, 1072, 1073, 1074, 1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085, 1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097, 1098, 1099, 1100, 1101, 1102, 1103, 1104, 1105, 1106, 1107, 1108, 1109, 1110, 1111, 1112, 1113, 1114, 1115, 1116, 1117, 1118, 1119, 1120, 1121, 1122, 1123, 1124, 1125, 1126, 1127, 112\n" +
            "                          googletag.cmd = googletag.cmd || [];\n" +
            "                          var slotRosselParallax;\n" +
            "                          var slotRosselParallax2;\n" +
            "                          var slotRosselParallax3;\n" +
            "                          var ySlot = -1.0;\n" +
            "                          var ySlot2 = -1.0;\n" +
            "                          var ySlot3 = -1.0;\n" +
            "                          googletag.cmd.push(function() {\n" +
            "                            googletag.pubads().setRequestNonPersonalizedAds(0);\n" +
            "                            // Slot \n" +
            "                            slotRosselParallax = googletag.defineSlot('/81985301/LESOIR/mobile', [300, 250], 'infeed').addService(googletag.pubads()).setTargeting(\"position\", \"center\");\n" +
            "                            slotRosselParallax2 = googletag.defineSlot('/81985301/LESOIR/mobile', [300, 250], 'infeed_2').addService(googletag.pubads()).setTargeting(\"position\", \"top\");\n" +
            "                            slotRosselParallax3 = googletag.defineSlot('/81985301/LESOIR/mobile', [300, 250], 'infeed_3').addService(googletag.pubads()).setTargeting(\"position\", \"bottom\");\n" +
            "                            /*      cXense    */\n" +
            "                            googletag.pubads().setTargeting(\"CxSegments\", [\"18i1jc8zw6c4d\", \"a9y3h13mfnl5\", \"a9y3h13mfnl6\", \"a9y3h13mfnmp\", \"a9y3h13mfnmq\", \"a9y7c1oy902v\", \"a9y7e6wp5r4l\", \"a9y7e6wp5r4x\", \"a9y7e6wp5r4y\", \"a9y7e6wp5r4z\", \"aa958xj2g9rt\", \"aa9664niwwhv\", \"aa96kkdsm2qs\", \"aa98ofi4356r\", \"aa9ahpx6m84o\", \"aa9ahpx6m84p\", \"aa9ahpx6m84q\", \"aa9ahpx6m84z\", \"aa9ahpx6m8aj\", \"aa9ahpx6m8ak\", \"aak9o4n6yer5\", \"aaka6nb6lf7g\", \"aakdl9e5jtfx\", \"aakdl9e5jtfy\", \"aakdl9e5jtgc\", \"aakdl9e5jtgh\", \"aakdl9e5jtlx\", \"aavcd5xrhfl5\", \"aavcrmxy1cfd\", \"aavcrmxy1cfe\", \"aavcrmxy1cff\", \"aavcrmxy1cfg\", \"aavcthjwrtik\", \"aavda75dd4x1\", \"aave48rhje9n\", \"aavevfu4h9g1\", \"aavevfu4h9g2\", \"aavfzfb44fp9\", \"aavgososbe7o\", \"aavgososbe9h\", \"aavgososbe9q\", \"itw4kuxb7kd9\", \"itw4kuxb7kdb\", \"itw5a70u2cvt\", \"itw5fq9mpk5q\", \"itw5fq9mpkc7\", \"itw5fq9mpkcc\", \"itw5fq9mpkci\", \"iu77o5yhwc7l\", \"iu77o5yhwc7m\", \"iu77o5yhwc7n\", \"iu77o5yhwc7o\", \"iu78dk8vicid\", \"iu78dk8vicie\", \"iu78dk8vicif\", \"iu78dk8vicig\", \"iu78dk8vicih\", \"iu78jaexaay0\", \"iu78jaexaay3\", \"iu78jaexaay6\", \"iuiarqts1pvu\", \"iuiarqts1pxu\", \"iuiarqts1pxv\", \"iuiarqts1pxw\", \"iuiarqts1pxx\", \"iuibh3ispfzh\", \"iuibh3ispfzi\", \"iuibh3ispfzj\", \"iuibh3ispfzk\", \"iuibh3ispfzl\", \"iuibh3ispfzm\", \"iuibh3ispfzn\", \"iutdvax8z6ke\", \"iutdvax8z6m3\", \"iutdvax8z6m4\", \"iuteby1f1mq2\", \"iv4gytdhelu4\", \"iv4gytdhelws\", \"iv4gytdhelwt\", \"iv4gytdhelwu\", \"iv4hvbcc3w3i\", \"iv4hvbcc3w3l\", \"ivfk31u12p7b\", \"ivfk31u12p7c\", \"ivfk31u12p7d\", \"ivfkiw49encu\", \"ivfkiw49enh0\", \"ivfkiw49enh1\", \"ivfkiw49enh2\", \"ivfkxet01tzy\", \"ivqn5zfsal6e\", \"ivqn5zfsal6f\", \"ivqn5zfsal8a\", \"ivqn5zfsal8c\", \"ivqn5zfsal8f\", \"ivqnmgbocdtv\", \"ivqnmgbocdtw\", \"ivqnmgbocdtx\", \"ivqnmgbocdtz\", \"ivqnmgbocdu0\", \"ivqnmgbocdu1\"]);\n" +
            "                            googletag.pubads().setTargeting(\"lang\", \"fr\");\n" +
            "                            googletag.pubads().enableSingleRequest();\n" +
            "                            googletag.pubads().collapseEmptyDivs(true, true);\n" +
            "                            googletag.pubads().disableInitialLoad();\n" +
            "                            googletag.enableServices();\n" +
            "                          });\n" +
            "\n" +
            "                          function scrollTo(scrollY) {\n" +
            "                            if (ySlot > 0 && scrollY > ySlot) {\n" +
            "                              googletag.pubads().refresh([slotRosselParallax]);\n" +
            "                              document.getElementById(\"infeed\").style.textAlign = \"center\";\n" +
            "                              ySlot = -1.0;\n" +
            "                            }\n" +
            "                            if (ySlot2 > 0 && scrollY > ySlot2) {\n" +
            "                              googletag.pubads().refresh([slotRosselParallax2]);\n" +
            "                              document.getElementById(\"infeed_2\").style.textAlign = \"center\";\n" +
            "                              ySlot2 = -1.0;\n" +
            "                            }\n" +
            "                            if (ySlot3 > 0 && scrollY > ySlot3) {\n" +
            "                              googletag.pubads().refresh([slotRosselParallax3]);\n" +
            "                              document.getElementById(\"infeed_3\").style.textAlign = \"center\";\n" +
            "                              ySlot3 = -1.0;\n" +
            "                            }\n" +
            "                          }\n" +
            "\n" +
            "                          function calculatePositions() {\n" +
            "                            ySlot = getY(\"rossel-imu-center-mobile\");\n" +
            "                            ySlot2 = getY(\"rossel-imu-center-mobile2\");\n" +
            "                            ySlot3 = getY(\"rossel-imu-center-mobile3\");\n" +
            "                          }\n" +
            "\n" +
            "                          function getY(elementId) {\n" +
            "                            var elem = document.getElementById(elementId);\n" +
            "                            if (elem != null) {\n" +
            "                              return elem.getBoundingClientRect().y;\n" +
            "                            } else {\n" +
            "                              return -1.0;\n" +
            "                            }\n" +
            "                          }\n" +
            "                          //WARNING: use differ for waiting for web view is loaded ! \n" +
            "                          window.onload = function() {\n" +
            "                            setTimeout(() => {\n" +
            "                              calculatePositions();\n" +
            "                            }, 1000);\n" +
            "                            alert(document.getElementsByClassName(\"r-embed--digiteka\")[0])\n" +
            "                          }\n" +
            "    </script>\n" +
            "    <script src=\"https://www.lesoir.be/sites/all/themes/enacarbon_lesoir/js/app.min.js\"></script>\n" +
            "    <link rel=\"stylesheet\" href=\"https://www.lesoir.be/sites/all/themes/enacarbon_lesoir/css/app.min.css\">\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    <div class='web_wrapper'>\n" +
            "      <article class=\"r-article\">\n" +
            "        <header class=\"r-article--header\">\n" +
            "          <h1 class=\"\">Niger: la junte rompt la coopération militaire avec Paris, recherche de sortie de crise</h1>\n" +
            "          <r-article--chapo>\n" +
            "            <p>Une délégation ouest-africaine dépêchée au Niger en est repartie dans la nuit de jeudi à vendredi, après avoir fait des propositions de «sortie de crise» auprès de membres de la junte qui ont annoncé la rupture de la coopération militaire avec la France.</p>\n" +
            "          </r-article--chapo>\n" +
            "        </header>\n" +
            "        <figure role=\"img\" class=\"r-ratio--16-9  r-article--main-img\" aria-label=\"NIGER-SECURITY_\">\n" +
            "          <img class=\"r-img\" srcset=\"/sites/default/files/dpistyles_v2/ls_16_9_864w/2023/08/04/node_486717/29917726/public/2023/08/04/B9732722599Z.1_20230804123228_000 GRFMAOSE2.2-0.jpg?itok=ADaHT1AV1691145159 864w\" typeof=\"foaf:Image\" src=\"/sites/default/files/dpistyles_v2/ls_16_9_864w/2023/08/04/node_486717/29917726/public/2023/08/04/B9732722599Z.1_20230804123228_000 GRFMAOSE2.2-0.jpg?itok=ADaHT1AV1691145159\" alt=\"NIGER-SECURITY_\" />\n" +
            "        </figure>\n" +
            "        <r-article--meta>\n" +
            "          <figure role=\"img\" class=\"r-author--img\">\n" +
            "            <img src=\"/sites/all/themes/enacarbon_lesoir/images/s-lesoir.svg\" class=\"r-img lazyloaded\" data-src=\"/sites/all/themes/enacarbon_lesoir/images/s-lesoir.svg\" alt=\"Image auteur par défaut\">\n" +
            "            <r-img class=\"not-lazy\" style=\"background-image: url('/sites/all/themes/enacarbon_lesoir/images/s-lesoir.svg')\"></r-img>\n" +
            "            <noscript>\n" +
            "              <img class=\"r-img\" src=\"/sites/all/themes/enacarbon_lesoir/images/s-lesoir.svg\" alt=\"Image auteur par défaut\" />\n" +
            "            </noscript>\n" +
            "          </figure>\n" +
            "          <span class=\"r-meta--top\">\n" +
            "            <address rel=\"author\">Par la rédaction </address>\n" +
            "          </span>\n" +
            "          <span class=\"r-meta--bottom\">\n" +
            "            <time class=\"\" datetime=\"2023-08-04T12:32:28\">Publié le 4/08/2023 à 12:32</time>\n" +
            "            <span class=\"r-readtime\">Temps de lecture: 4 min <r-icon class=\"r-icon--tempsdelecture\"></r-icon>\n" +
            "            </span>\n" +
            "          </span>\n" +
            "        </r-article--meta>\n" +
            "        <r-article--section>\n" +
            "          <p>Tard jeudi, dans un communiqué lu à la télévision, les putschistes ont dénoncé «les accords de coopération dans le domaine de la sécurité et de la défense avec la France», dont un contingent militaire de 1.500 soldats est déployé au Niger pour la lutte antiterroriste dans ce pays miné par les violences jihadistes.</p>\n" +
            "          <p>Dans la nuit de jeudi à vendredi, une délégation de la Communauté économique des Etats d’Afrique de l’ouest (Cédéao), conduite par l’ex-président nigérian Abdulsalami Abubakar est repartie de Niamey après quelques heures.</p>\n" +
            "        </r-article--section>\n" +
            "        <template class=\"js-sso--template\" data-user=\"abonne\">\n" +
            "          <r-pub class=\"r-pub--inread rossel-imu-center-mobile2\">\n" +
            "            <i-pub  id=\"rossel-imu-center-mobile2\">\n" +
            "              <!--   // builder=DFPTagBuilder, site=LESOIRV2, pageType=page, context=/API, position=infeed_2, edition=, domain=stage.lesoir.be \n" +
            "                                                                                                         \n" +
            "                                                                                                     -->\n" +
            "              <div id='infeed_2'>\n" +
            "                <script type='text/javascript'>\n" +
            "                  googletag.cmd.push(function() {\n" +
            "                    googletag.display('infeed_2');\n" +
            "                  });\n" +
            "                </script>\n" +
            "              </div>\n" +
            "            </i-pub>\n" +
            "          </r-pub>\n" +
            "        </template>\n" +
            "        <r-pub class=\"r-pub--inread rossel-imu-center-mobile2\">\n" +
            "          <i-pub  id=\"rossel-imu-center-mobile2\">\n" +
            "            <!--   // builder=DFPTagBuilder, site=LESOIRV2, pageType=page, context=/API, position=infeed_2, edition=, domain=stage.lesoir.be \n" +
            "                                                                                                         \n" +
            "                                                                                                     -->\n" +
            "            <div id='infeed_2'>\n" +
            "              <script type='text/javascript'>\n" +
            "                googletag.cmd.push(function() {\n" +
            "                  googletag.display('infeed_2');\n" +
            "                });\n" +
            "              </script>\n" +
            "            </div>\n" +
            "          </i-pub>\n" +
            "        </r-pub>\n" +
            "        <r-article--section>\n" +
            "          <p>Si les émissaires n’ont pas rencontré le chef de la junte, le général Abdourahamane Tiani, ni le président renversé Mohamed Bazoum, ils se sont entretenus à l’aéroport avec des militaires putschistes et ont évoqué «les dernières propositions de sortie de crise de la Cedeao», selon le quotidien gouvernemental nigérien Le Sahel.</p>\n" +
            "          <p>Le 30 juillet, la Cédéao, qui a imposé de lourdes sanctions à Niamey, a donné jusqu’à dimanche aux putschistes pour rétablir dans ses fonctions le président Mohamed Bazoum renversé le 26 juillet, sous peine de d’utiliser «la force».</p>\n" +
            "          <p>Une réunion des chefs d’état-major de la Cédéao doit s’achever vendredi après-midi à Abuja, alors que plusieurs armées ouest-africaines, dont celle du Sénégal, se disent prêtes à envoyer des soldats si une intervention militaire était décidée.</p>\n" +
            "          <h2> «Riposte immédiate» </h2>\n" +
            "          <p>Les putschistes qui ont promis une «riposte immédiate» à «toute agression» de la part d’un pays de la Cédéao ont par ailleurs annoncé la levée du couvre-feu instauré depuis leur prise de pouvoir le 26 juillet.</p>\n" +
            "          <p>Vendredi matin, une centaine de manifestants originaires de plusieurs pays ouest-africains se sont réunis à Niamey pour protester contre toute intervention militaire au Niger.</p>\n" +
            "          <p>\n" +
            "            <!-- scald=29917727:full {\"context\":\"full\",\"view_mode\":\"enacarbon_article_default\",\"scald_mediacontext\":\"full\",\"dpiservices\":true} -->\n" +
            "            <r-embed class=\"r-embed--digiteka\">\n" +
            "              <iframe title=\"Digiteka\" class=\"lazy\" data-src=\"https://www.ultimedia.com/deliver/generic/iframe/showtitle/1/mdtk/01989741/zone/1/src/qkkqrpz/gdprconsentstring/CPv-nsAPv-nsAAHABAFRDQCsAP_AAAAAAAAAJkNf_X__b3_r-_7___t0eY1f9_7__-0zjhfdh-8N3f_X_L8X_2M7vF36tq4KuR4ku3bBIUdlHPHcTVmw6okVrzPsbk2cr7NKJ7PEmlMbc2dYGH9_n9_z-ZKY7_-_f__7__-____9_____-_____5__-___b_V_-97fn9_____9_P___9v__8___v______3____7_D_-f_-7_XQAAAEkoAMAARBQDQAYAAiCgKgAwABEFApABgACIKA6ADAAEQUCEAGAAIgoBIAMAARBQEQAYAAiCgMgAwABEFA?urlfacebook=https://stage.lesoir.be/486717/article/2023-08-04/niger-la-junte-rompt-la-cooperation-militaire-avec-paris-recherche-de-sortie-de&tagparamdecoded=News&tagparam=cat%3Dnews\" scrolling=\"no\" frameborder=\"0\" marginwidth=\"0\" marginheight=\"0\" hspace=\"0\" vspace=\"0\" style=\"z-index:1;\" allowfullscreen=\"true\" webkitallowfullscreen=\"true\" mozallowfullscreen=\"true\" width=\"100%\" height=\"400\" referrerpolicy=\"no-referrer-when-downgrade\" data-digiteka-sid=\"29917727\"></iframe>\n" +
            "            </r-embed>\n" +
            "            <!-- END scald=29917727 -->\n" +
            "          </p>\n" +
            "          <p>Le président déchu Mohamed Bazoum s’est de son côté exprimé jeudi soir, dans une tribune publiée par le quotidien américain Washington Post. Il a mis en garde contre les conséquences «dévastatrices» du coup d’Etat pour le monde et le Sahel, qui pourrait passer, selon lui, sous l’«influence» de la Russie par le biais du groupe paramilitaire Wagner.</p>\n" +
            "          <p>«J’appelle le gouvernement américain et l’ensemble de la communauté internationale à aider à restaurer l’ordre constitutionnel», écrit-il, «à titre d’otage», dans cette déclaration.</p>\n" +
            "          <p>M. Bazoum, 63 ans, est retenu avec sa famille depuis le jour du putsch dans sa résidence présidentielle.</p>\n" +
            "          <p>Si les relations sont tendues entre la junte et le bloc ouest-africain, elles le sont aussi de plus en plus avec la France, ancienne puissance coloniale.</p>\n" +
            "          <p>Outre la dénonciation des accords militaires, l’ambassadeur nigérien à Paris a été limogé par les putschistes, tout comme ceux aux Etats-Unis, au Togo et au Nigeria.</p>\n" +
            "          <h2> Medias français coupés </h2>\n" +
            "          <p>Jeudi, les programmes de Radio France Internationale (RFI) et de la chaîne de télévision d’information France 24 ont été interrompus au Niger, «une décision prise hors de tout cadre conventionnel et légal», selon la maison-mère des deux médias, France Médias Monde.</p>\n" +
            "          <p>Les signaux ont été coupés «sur instructions des nouvelles autorités militaires», a indiqué à l’AFP un haut fonctionnai                                                                                                            -->\n" +
            "          <div id='rossel-imu-center-mobile'></div>\n" +
            "          </i-pub>\n" +
            "          </r-pub>\n" +
            "          <r-pub class=\"r-pub--inread rossel-imu-center-mobile\">\n" +
            "            <i-pub  id=\"rossel-imu-center-mobile\">\n" +
            "              <!--   // builder=DFPTagBuilder, site=LESOIRV2, pageType=page, context=/API, position=infeed, edition=, domain=stage.lesoir.be \n" +
            "                                                                                                         \n" +
            "                                                                                                     -->\n" +
            "              <div id='infeed'>\n" +
            "                <script type='text/javascript'>\n" +
            "                  googletag.cmd.push(function() {\n" +
            "                    googletag.display('infeed');\n" +
            "                  });\n" +
            "                </script>\n" +
            "              </div>\n" +
            "            </i-pub>\n" +
            "          </r-pub>\n" +
            "          <r-article--section>\n" +
            "            <p>bur-pid/stb/jg</p>\n" +
            "            <p>AFP </p>\n" +
            "          </r-article--section>\n" +
            "          <article>\n" +
            "    </div>\n" +
            "  </body>\n" +
            "</html>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val articleList = listOf(bodyHTML, bodyHTML, bodyHTML)

        viewPager.adapter = ArticlePagerAdapter(articleList)

        /* webview = findViewById(R.id.idDtkWebView)

         webview.apply {
             settings.javaScriptEnabled = true
             isScrollContainer=true
             loadUrl("https://mockup.digiteka.com/mockup_rossel_android.html")
         }*/
    }
}