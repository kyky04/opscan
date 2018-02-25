package com.skripsi.innasya.optscan.Reference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.skripsi.innasya.optscan.Preference.AppResizeImage;
import com.skripsi.innasya.optscan.R;

import java.util.ArrayList;

/**
 * Created by Innasya Rahmania on 22/04/2017.
 */

public class resource {

    public int pixelSize = 77;
    public Context context;
    public String [][] dataRowPestisida = {
            {"1", "AMPLIGO 150 ZC", "Insektisida racun kontak dan lambung ", "lamda sihalotrin + klorantraniliprol", "3A + 28 {modulator saluran natrium, menyebabkan saluran natrium pada askon saraf selalu terbuka + mengaktifkan reseptor rianodin }", "II + U {cukup bahaya}", "1"},
            {"2",
                    "BASAMID 98 GR",
                    "Nematisida, fungisida dan insektisida",
                    "Nematisida, fungisida dan insektisida",
                    "8F {Menghambat pembentukan sel}",
                    "II  {cukup bahaya}",
                    "1"},
            {"3", "DIAZINON 10 GR", "Insektisida sistemik, racun kontak dan lambung ", "diazionin", "1B {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup berbahaya}", "1"},
            {"4", "DURSBAN 200 EC", "Insektisida sistemik, racun kontak dan lambung ", "klorpirifos", "1B {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup berbahaya}", "1"},
            {"5", "MATADOR 25 CS ", "Insektisida sistemik, racun kontak dan lambung ", "lamda sihalotrin ", "3A {Modulator saluran natrium, menyebabkan saluran natrium pada askon saraf selalu terbuka}", "II {cukup berbahaya}", "1"},
            {"6", "REGENT 0,3 GR ", "Insektisida sistemik, racun kontak dan lambung ", "fipronil", "2B {Memblokir saluran klorida aktiva GABA pada saraf serangga}", "II {cukup berbahaya}", "1"},
            {"7", "TOTAL MAX", "Insektisida racun kontak dan lambung ", "Imidakloprid + sipermetrin", "4A + 3A {Meniru tindakan persaingan asetikolin pada reseptor  nAChRs + modulator saluran natrium, menyebabkan saluran natrium pada askon saraf yang terbuka}", "II + II {cukup berbahaya}", "1"},
            {"8", "DIAZINON 10 R", "Insektisida sistemik, racun kontak dan lambung ", "diazinon", "1B {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup berbahaya}", "2"},
            {"9", "INDOFURAN 3 GR", "Insektisida sistemik, dan racun lambung ", "karbofuran", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat berbahaya}", "2"},
            {"10", "JORDAN 5 GR ", "Insektisida racun kontak dan lambung}", "karbofuran", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat berbahaya}", "2"},
            {"11", "KARDAN 4 GR ", "Insektisida sistemik, rancun kontak dan lambung}", "kartap hidroklorida", "14 {Memblokir saluran ion nAChR}", "II {cukup berbahaya}", "2"},
            {"12", "MARSHAL 5 GR ", "Insektisida dan nematisida sistemik, racun kontak dan lambung ", "karbosulfan", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup berbahaya}", "2"},
            {"13", "NEOFRON 3 GR ", "Insektisida racun kontak dan lambung}", "fipronil", "2B {Memblokir saluran klorida aktivasi GABA pada saraf serangga}", "II {cukup berbahaya}", "2"},
            {"14", "PETROFUR 3 GR", "Insektisida dan nematisida sistemik, racun kontak dan lambung ", "karbofuran", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat berbahaya}", "2"},
            {"15", "SIDAFUR 3 GR ", "Insektisida racun kontak dan lambung", "karbofuran", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat berbahaya}", "2"},
            {"16", "TRUPER 3 GR", "Insektisida racun kontak dan lambung", "karbofuran", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat berbahaya}", "2"},
            {"17", "MARSHAL 5 GR ", "Insektisida dan nematisida sistemik, racun kontak dan lambung ", "karbosulfan", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup berbahaya}", "2"},
            {"18", "NEOFRON 3 GR ", "Insektisida racun kontak dan lambung", "fipronil", "2B {Memblokir saluran klorida aktivasi GABA pada saraf serangga}", "II {cukup berbahaya}", "2"},
            {"19", "PETROFUR 3 GR", "Insektisida dan nematisida sistemik, racun kontak dan lambung ", "karbofuran", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat berbahaya}", "2"},
            {"20", "SIDAFUR 3 GR ", "Insektisida racun kontak dan lambung", "karbofuran", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat berbahaya}", "2"},
            {"21", "TRUPER 3 GR", "Insektisida racun kontak dan lambung", "karbofuran", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat berbahaya}", "2"},
            {"22", "MARSHAL 25 DS", "Insektisida sistemik,racun kontak dan lambung ", "karbosulfan", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup berbahaya}", "3"},
            {"23", "REGENT 0,3 GR", "Insektisida sistemik, racun kontak dan lambung ", "Fipronil", "2B {Memblokir saluran klorida aktivasi GABA pada saraf serangga}", "II {cukup berbahaya}", "3"},
            {"24", "DIAZINON 10 GR", "Insektisida sistemik, racun kontak dan lambung ", "diazinon", "1B {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup berbahaya}", "3"},
            {"25", "INDOFURAN 3 GR", "Insektisida sistemik, racun kontak dan lambung ", "karbofuran", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat bahaya}", "3"},
            {"26", "JORDAN 5 GR", "Insektisida racun kontak dan lambung ", "karbofuran", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat bahaya}", "3"},
            {"27", "KARDAN 4 GR", "Insektisida sistemik, racun kontak dan lambung ", "kartap hidroklorida", "14 {Memblokir saluran ion nAChR}", "II {cukup berbahaya}", "3"},
            {"28", "MARSHAL 5 GR", "Insektisida dan nematisida sistemik, racun kontak dan lambung ", "karbosulfan", "1A {Menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup berbahaya}", "3"},
            {"29", "NEOFRON 3 GR ", "Insektisida racun kontak dan lambung ", "Fipronil", "2B {memblokir saluran klorida aktivasi GABA pada saraf serangga}", "II {cukup berbahaya}", "3"},
            {"30", "PETROFUR 3 GR ", "Insektisida dan nematisida sistemik, racun kontak dan lambung ", "karbofuran", "1A {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat bahaya}", "3"},
            {"31", "SIDAFUR 3 GR ", "Insektisida racun kontak dan lambung ", "karbofuran", "1A {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat bahaya}", "3"},
            {"32", "TRUPER 3 GR ", "Insektisida racun kontak dan lambung ", "karbofuran", "1A {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat bahaya}", "3"},
            {"33", "NEOFRON 3 GR ", "Insektisida racun kontak dan lambung ", "Fipronil", "2B {memblokir saluran klorida aktivasi GABA pada saraf serangga}", "II {cukup berbahaya}", "3"},
            {"34", "PETROFUR 3 GR ", "Insektisida dan nematisida sistemik, racun kontak dan lambung ", "karbofuran", "1A {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat bahaya}", "3"},
            {"35", "SIDAFUR 3 GR ", "Insektisida racun kontak dan lambung ", "karbofuran", "1A {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat bahaya}", "3"},
            {"36", "TRUPER 3 GR ", "Insektisida racun kontak dan lambung ", "karbofuran", "1A {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "Ib {sangat bahaya}", "3"},
            {"37", "ABACEL 18 EC", "Insektisida racun kontak dan lambung", "abamektin", "6 {mengaktifkan saluran utama klorida glutamat {GluCls} + mengaktifkan saluran utama klorida glutamat {GluCls}", "? Tingkat bahayanya belum diketahui}", "4"},
            {"38", "ACEDO 75 SP", "Insektisida sistemik , racun kontak dan lambung", "asefat", "1B {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup berbahaya}", "4"},
            {"39", "ACHILES 300 EC", "Insektisida racun kontak dan lambung ", "klorfenapir", "1B {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup berbahaya}", "4"},
            {"40", "ADITRIN 50 EC", "Insektisida racun kontak dan lambung ", "lamda sihalotrin", "3A {Modulator saluran natrium, menyebabkan saluran natrium pada askon saraf selalu terbuka}", "II {cukup berbahaya}", "4"},
            {"41", "AFFENDER 25 EC", "Insektisida racun kontak dan lambung ", "deltametrin", "3A {Modulator saluran natrium, menyebabkan saluran natrium pada askon saraf selalu terbuka}", "II {cukup berbahaya}", "4"},
            {"42", "AGRESOR 50 EC", "Insektisida racun kontak dan lambung ", "deltametrin", "3A {Modulator saluran natrium, menyebabkan saluran natrium pada askon saraf selalu terbuka}", "II {cukup berbahaya}", "4"},
            {"43", "AGSPON 400 SL ", "Insekstisida sistemik, racun kontak dan lambung ", "dimehipo", "14 {memblokirsaluran ion nAChR}", "II {cukup berbahaya}", "4"},
            {"44", "AGSTAP 50 SP ", "Insekstisida racun kontak,lambung,dan sistemik", "kartap hidroklorida", "14 {memblokirsaluran ion nAChR}", "II {cukup berbahaya}", "4"},
            {"45", "AKSIGUA 50 ME ", "Insektisida racun kontak dan lambung", "lamda sihalotrin", "3A {modulator saluran natrium, menyebabkan saluran natrium pada askon saraf selalu terbuka}", "II {cukup berbahaya}", "4"},
            {"46", "ALBIAS 75 SP ", "Insektisida sistemik", "asefat", "1B {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup berbahaya}", "4"},
            {"47", "ALFAMEX 18  EC", "Insektisida racun kontak lambung", "abamekin", "6 {mengaktifkan saluran utama klorida glutamat {GluCls}}", "?{tingkat bahayanya belum diketahui}", "5"},
            {"48", "BALISTIC 50 SC", "Insektisida sistemik, racun kontak dan lambung", "fipronil", "2B {memblokir saluran klorida aktivasi GABA pada saraf serangga}", "II {cukup berbahaya}", "5"},
            {"49", "CATCHER 18 EC", "Insektisida racun kontak dan lambung", "abamektin", "6 {mengaktifkan saluran utama klorida glutamat {GluCls}}", "? {tingkat berbahayanya belum diketahui}", "5"},
            {"50", "CENTAMEC 36", "Insektisida racun kontak dan lambung", "abamektin", "6 {mengaktifkan saluran utama klorida glutamat {GluCls}}", "? {tingkat berbahayanya belum diketahui}", "5"},
            {"51", "CRONUS 18 EC", "Insektisida racun kontak dan lambung", "abamektin", "6 {mengaktifkan saluran utama klorida glutamat {GluCls}}", "? {tingkat berbahayanya belum diketahui}", "5"},
            {"52", "CYPERMAX 200 EC", "Insektisida racun kontak dan lambung", "abamektin", "6 {mengaktifkan saluran utama klorida glutamat {GluCls}}", "? {tingkat berbahayanya belum diketahui}", "5"},
            {"53", "CYRROTEX 75 SP", "Insektisida sistemik, racun kontak dan lambung", "siromazin", "17 {menganggu proses pergantian kulit serangga pada ordo diptera}", "III {agak berbahaya}", "5"},
            {"54", "DAFAT 75 SP", "Insektisida sistemik, racun kontak dan lambung", "asefat", "1B {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup berbahaya}", "5"},
            {"55", "DEMOLISH 18 EC", "Insektisida racun kontak dan lambung", "abamektin", "6 {mengaktifkan saluran utama klorida glutamat {GluCls}}", "? {tingkat berbahayanya belum diketahui}", "5"},
            {"56", "FIPKILL 50 SC", "Insektisida racun kontak dan lambung", "fipronil", "2B {memblokir saluran klorida aktivasi GABA pada saraf serangga}", "", "6"},
            {"57", "ALFAMEX 18 EC", "Trips bawang", "abamektin", "6 {mengaktifkan saluran utama klorida glutamat {GluCls}}", "? {tingkat bahayanya belum diketahui}", "6"},
            {"58", "BULDOK 25 EC", "Insektisida racun kontak dan lambung", "beta siflutrin", "3A {modulator saluran natrium, menyebabkan saluran natrium pada askon saraf selalu terbuka}", "Ib {cukup berbahaya}", "6"},
            {"59", "CATCHER 18 EC", "Insektisida racun kontak dan lambung", "abamektin", "6 {mengaktifkan saluran utama klorida glutamat {GluCls}}", "? {tingkat bahayanya belum diketahui}", "6"},
            {"60", "CLOBBER 200 EC", "Insektisida racun kontak, lambung dan pernafasan", "klorpiripos", "1B {menghambat kerja enzim asetilkoliesterase pada saraf serangga}", "II {cukup berbahaya}", "6"},
            {"61", "CRONUS 18 EC", "Insektisida racun kontak dan lambung", "abamektin", "6 {mengaktifkan saluran utama klorida glutamat {GluCls}}", "? {tingkat bahayanya belum diketahui}", "6"},
            {"62", "CYPERMAX 200 EC", "Insektisida sistemik, racun kontak dan lambung", "sipermetrin", "3A {modulator saluran natrium, menyebabkan saluran natrium pada askon saraf selalu terbuka}", "II {cukup berbahaya}", "6"},
            {"63", "FASTOP 100 EC", "Insektisida sistemik", "alfa sipermetrin", "3A {modulator saluran natrium, menyebabkan saluran natrium pada askon saraf selalu terbuka}", "II {cukup berbahaya}", "6"},
            {"64", "INDIMEKTIN 20 EC", "Insektisida racun kontak dan lambung", "abamektin", "6 {mengaktifkan saluran utama klorida glutamat {GluCls}}", "? {tingkat bahayanya belum diketahui}", "6"},
            {"65", "MOVENTO ENERGY 240 SC", "Insektisida sistemik, racun kontak dan lambung", "imidakloprid +spirotetramat", "4A + 23 {meniru tindakan persaingan asetilkolon pada reseptor nAChRs + menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II + III {cukup berbahaya}", "6"},
            {"66", "PADAN 50 NP", "Insektisida sistemik, racun kontak dan lambung", "kartap hidroklorida", "14 {memblokir saluran ion nAChR}", "II {cukup berbahaya}", "6"},
            {"67", "KRESBAN 200 EC", "Insektisida racun kontak dan lambung", "klorpirifos", "1B {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup bahaya}", "7"},
            {"68", "SERGAP 410 EC", "Insektisida racun kontak dan lambung", "klorpirifos", "1B {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup bahaya}", "7"},
            {"69", "BAJAJ 450 SL", "Insektisida sistemik, racun kontak dan lambung", "demehipo", "14 {memblokir saluran ion nAChR}", "II {cukup bahaya}", "7"},
            {"70", "BALISTIC 50 SC", "Insektisida sistemik, racun kontak dan lambung", "fipronil", "2B {memblokir saluran klorida aktivasi GABA pada saraf serangga}", "II {cukup bahaya}", "7"},
            {"71", "BESGRIMEX 36 EC", "Insektisida racun kontak dan lambung", "abammekin", "6 {mengaktifkan saluran utama klorida glutamat}", "? {tingkat bahayanya belum diketahui}", "7"},
            {"72", "BESTFAST 250 EC", "Insektisida racun kontak dan lambung", "klorfenapir", "1B {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup bahaya}", "7"},
            {"73", "BESTOX 50 EC", "Insektisida racun kontak dan lambung", "alfa spertrin", "3A {Modulator saluran natrium, menyebabkan saluran natrium pada askonsaraf slalu terbuka}", "II {cukup bahaya}", "7"},
            {"74", "BESTRIN FORTE PLUS 100 EC", "Insektisida racun kontak dan lambung", "sipermetrin", "3A {Modulator saluran natrium, menyebabkan saluran natrium pada askonsaraf slalu terbuka}", "II {cukup bahaya}", "7"},
            {"75", "BIMA 10 WP", "Insektisida sistemik, racun kontak dan lambung", "imidakloprid", "4A {meniru tindakan persaingan asetilkolin pada resptor nAChRs}", "II {cukup bahaya}", "7"},
            {"76", "BIOCHLORMETHYL 500 EC", "Insektisida racun kontak,lambung dan pernafasan", "metil klorpirifos", "1B {menghambat kerja enzim asetilkolinesterase pada saraf serangga}", "II {cukup bahaya}", "7"}
    };

    public String [][] OPT = {
            {"1","Ulat tanah","Agrotis Ipsilon","Serangga dewasa berupa ngengat yang aktif terbang pada malam hari. Tubuh serangga dewasa keabu-abuan dengan sayap berwarna kelabu dengan tanda hitam coklat. Ulat berwarna hitam keabu-abuan, aktif merusak tanaman pada malam hari dan kadang-kadang bersifat kanibal. Gejala serangannya ditandai dengan adanya tanaman muda yang patah atau tangkai daunnya terpotong. Tanaman inangnya ialah tanaman muda yang baru ditanam seperti bawang merah, kubis bunga, jagung, kacang panjang, dan lain-lain."},
            {"2","Uret","Lepidiota Stigma","merupakan larva dari kumbang. Kepala larva berwarna putih kemerahan dan ciri khas uret ialah perutnya dalam posisi membengkok. Gejala serangan ditandai dengan adanya tanaman muda yang roboh karena pangkal batangnya dipotong. Tanaman inang lainnya antara lain ialah padi, jagung, kentang, mentimun, kubis, tomat, wortel dan cabai."},
            {"3","Orong - Orong","Gryllotalpa sp.","Serangga berwarna coklat kehitaman menyerupai cengkerik dengan sepasang kaki depan yang kuat. Sifatnya sangat polifag, memakan akar, umbi, ubi dan tanaman muda. Gejala serangan ditandai dengan tanaman atau tangkai daun rebah, karena pangkalnya dipotong. Tanaman inangnya ialah tanaman muda yang baru ditanam seperti tomat, terung, bayam, kangkung, paria, kacang panjang, dan kentang."},
            {"4","Ulat Bawang","Spodoptera exigua","Serangga dewasa berupa ngengat berwarna kelabu yang mampu bertelur sebanyak 500-600 butir. Larva/ ulat berbentuk bulat panjang berwarna hijau atau coklat dengan kepala berwarna kuning kehijauan. Telur diletakkan secara berkelompok yang diselimuti oleh benang-benang halus pada daun bawang. Larva instar pertama masuk ke dalam polong daun. Gejala serangan ditandai dengan adanya bercak-bercak putih transparan, karena ulat memakan daging daun, sedangkan epidermis ditinggalkan. Tanaman inangnya antara lain ialah bawang merah, bawang kucai, bawang daun, bawang putih, cabai, dan jagung. Penyemprotan dengan insektisida yang efektif dan dianjurkan dilakukan jika rata-rata populasi kelompok telur telah mencapai 1 kelompok telur/ 10 tanaman, atau kerusakan daun 5%, atau populasi ngengat yang tertangkap oleh perangkap feromon telah mencapai 30 ekor/ perangkap/ tiga hari."},
            {"5","Lalat Pengorok Daun","Liriomyza sp.","Serangga dewasa lalat pengorok daun berupa lalat kecil yang berukuran ±2 mm. Larva aktif mengorok dan membuat lubang pada jaringan daun. Gejala serangan ditandai adanya bintik-bintik putih dan alur korokan yang berwarna putih pada permukaan daun. Tanaman inangnya antara lain ialah bawang merah, buncis, kacang panjang, kentang, labu, mentimun oyong, seledri, semangka, tomat, dan terung."},
            {"6","Kutu Daun bawang","Neotoxoptera Formosana","Kutu daun bawang (Neotoxoptera formosana). Kutu daun yang umum menyerang tanaman bawang merah ialah Neotoxoptera formosana. Gejala serangan kutu daun menyebabkan daun yang terserang berkeriput, kekuningan, terpuntir, pertumbuhan tanaman terhambat, layu lalu mati. Tanaman inangnya antara lain ialah bawang daun dan bawang kucai."},
            {"7","Tripis","Thrips Tabaci","Panjang Tubuh serangga dewasa ±1-1,33 mm. Nimfa trips tidak bersayap, sedangkan trips dewasa bersayap seperti jumbai (sisir bersisir dua). Tubuh berwarna kuning, coklat kekuningan atau coklat. Gejala serangan ditandai dengan warna keperak-perakan atau bercak-bercak putih pada daun, selanjutnya daun mongering. Tanaman inangnya antara lain ialah bawang merah, bawang daun, buncis, kacang panjang, kentang, labu, mentimun, oyong, paria, semangka, tomat dan terung. Trips bawang juga merupakan vector  cendawan alternaria porri yang menyebabkan penyakit bercak ungu"},
            {"8","Ulat Grayak","Spodoptera litura","Serangan dewasa berupa ngengat berwarna Coklat. Larva/ ulat Mempunyai warna bervariasi, tetapi mempunyai ciri khas yaitu terdapat nokhta hitam pada ruas abdomen keempat dan kesepuluh. Hama ini bersifat polifag. Gejala serangan oleh ulat instar muda ditandai daun-daun berlubang dan epidermis bagian atas ditinggalkan, memakan seluruh bagian daun termasuk tulang daun dan buah dimakan. Hamper semua tanaman diserang oleh hama ini. Penyemprotan dengan insektisida dapat dilakukan jika kerusakan sudah mencapai 5%."}
    };

    public String [][] kelompokPenyakit = {
            {"1","Bercak Ungu","alternaria","awal timbulnya bercak kecil di daun-daun bagian bawah, kemudian berkembang dengan diameter mencapai ± 15 mm. Warna bercak coklat dengan lingkaran lingkaran sepusat"},
            {"2","Bercak Daun","antraknos","Penyakit busuk daun antraknos atau otomatis (istilah di Brebes, Jawa Tengah) disebabkan oleh cendawan Colletotrichum gloeosporioides . Patogen ditularkan melalui udara. Gejala serangan dimulai dengan timbulnya bercak coklat kehitaman pada permukan daun, kemudian bercak menjadi lunak. Pada bagian tengah bercak terdapat kumpulan titik hitam yang merupakan kelompok spora.  Pada serangan berat menyebabkan seluruh permukaan daun keriput dan mengering dan warna daun seperti jerami padi. Pada saat cuaca panas dan lembab penyakit ini akan cepat berkembang. Tanaman inangnya antara lain ialah bawang merah, tomat, buncis, kacang panjang labu, mentimun, oyong, paria, semangka, dan terung."},
            {"3","Embun Bulu atau Busuk Daun","downny mildew","Penyakit embun bulu atau busuk daun ( downy mildew ) disebabkan oleh cendawan Pseudoperonospora cubensis . Patogen penyakit embun bulu ditularkan melalui angin. Gejala serangan pada tanaman bawang merah ditandai daun berwarna pucat dan menguning. Bila udara lembab, daun yang terserang akan menunjukkan bintik-bintik berwarna ungu dan membusuk, sedangkan bila udara kering daun yang terserang akan menunjukkan bintik-bintik putih. Gejala pada mentimun pada daun terdapat bercak bersudut klorotik lembab, bagian bawah daun menjadi abu-abu coklat hingga hitam keunguan. Daun menjadi nekrotik dan mengeriting ke atas. Kondisi optimum untuk perkembangan penyakit ini ialah pada suhu 15o C dan kelembaban tinggi terjadi selama 6-12 jam"},
            {"4","Layu Fusarium","Layu Fusarium","Penyakit layu fusarium disebabkan oleh cendawan Fusarium oxysporum . Patogen ditularkan melalui udara dan air. Gejala serangan ditandai tanaman menjadi layu, mulai dari daun bagian bawah. Anak tulang daun menguning. Jaringan batang dan akar berwarna coklat. Tanaman inangnya antara lain ialah bawang merah, buncis, cabai kentang, kacang panjang, labu, mentimun, oyong, paria, seledri, semangka, tomat, dan terung. "},
            {"5","Busuk Leher Akar","Busuk Leher Akar","Penyakit busuk leher akar disebabkan oleh cendawan Botrytis allii. Patogen ditularkan melalui udara. Penyakit ini akan berkembang dengan cepat pada kondisi kelembaban tinggi dan suhu udara rata-rata di atas 15-20oC, lahan yang becek dan lembab. Gejala serangan ditandai dengan leher tanaman melunak kemudian membusuk. Tanaman inangnya antara lain ialah bawang merah, bawang putih, bawang daun, dan tanaman bawang-bawangan lainnya."}
    };

    public int [] getGambarKelompok = {
            R.drawable.bercak_daun,
            R.drawable.busuk_daun,
            R.drawable.embun_bulu,
            R.drawable.layu_fusarium,
            R.drawable.busuk_leher_akar
    };

    public int [] getGambarDataRowOPT = {
            R.drawable.ulat_tanah,
            R.drawable.opt_lepidiota_stigma,
            R.drawable.opt_gryllotalpa,
            R.drawable.opt_spodoptera,
            R.drawable.opt_liriomyza,
            R.drawable.opt_neotoxoptera_formosana,
            R.drawable.tripis,
            R.drawable.opt_agrotis_ipsilon
    };

    public resource(Context context){
        this.context = context;
    }

    public ArrayList<Bitmap> getDataLatihSatu(){
        ArrayList<Bitmap> data = new ArrayList<Bitmap>();
        data.add(BitmapDecoder(R.drawable.__ulat_tanah));
        data.add(BitmapDecoder(R.drawable.train_lepidiota_stigma));
        data.add(BitmapDecoder(R.drawable.train_gryllotalpa));
        data.add(BitmapDecoder(R.drawable.train_spodoptera));
        data.add(BitmapDecoder(R.drawable.train_liriomyza));
        data.add(BitmapDecoder(R.drawable.train_neotoxoptera));
        data.add(BitmapDecoder(R.drawable.__train_tripis));
        data.add(BitmapDecoder(R.drawable.train_agrotis_ipsilon));

        return data;
    }

    public ArrayList<Bitmap> getDataLatihDua(){
        ArrayList<Bitmap> data = new ArrayList<Bitmap>();
        data.add(BitmapDecoder(R.drawable.opt_agrotis_ipsilon));
        data.add(BitmapDecoder(R.drawable.opt_lepidiota_stigma));
        data.add(BitmapDecoder(R.drawable.opt_gryllotalpa));
        data.add(BitmapDecoder(R.drawable.opt_spodoptera));
        data.add(BitmapDecoder(R.drawable.opt_liriomyza));
        data.add(BitmapDecoder(R.drawable.opt_neotoxoptera_formosana));

        return data;
    }

    public int [] getGambarDataRowOPT(){
        return this.getGambarDataRowOPT;
    }

    public int [] getGambarDataRowKelompok(){
        return this.getGambarKelompok;
    }

    public int pixelSize(){
        return pixelSize;
    }

    public String [][] getDataRowPestisida(){
        return this.dataRowPestisida;
    }

    public String [][] getDataRowKelompok(){
        return this.kelompokPenyakit;
    }

    public String [][] getDataRowOPT(){
        return this.OPT;
    }

    private Bitmap BitmapDecoder(int a){
        return new AppResizeImage().getResizeImage(BitmapFactory.decodeResource(context.getResources(), a),pixelSize,pixelSize);
    }
}