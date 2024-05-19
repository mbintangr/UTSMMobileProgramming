package com.example.uts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class BeritaFragment : Fragment() {
    private var lv: ListView? = null
    private var beritaList: ArrayList<BeritaData>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.berita_fragment, container, false)
        lv = view.findViewById(R.id.lvBerita)
        initData()
        val adapter = BeritaAdapter(activity, beritaList)
        lv?.adapter = adapter
        return view
    }

    private fun initData() {
        beritaList = ArrayList()
        for (i in 0 .. 4) {
            beritaList!!.add(BeritaData("Ahli Deteksi Lautan Raksasa Lebih dari 660 Km di Bawah Bumi, Bagaimana Menemukannya?", "Bayangkan sebuah samudra yang begitu luas sehingga volume keseluruhan dari semua samudra di Bumi menjadi tiga kali lipat lebih besar, tetapi tak terlihat dari tepi pantai, bahkan satelit.", "https://akcdn.detik.net.id/community/media/visual/2018/11/02/15e7da17-cd2c-4fa6-b9f9-da016783675c.jpeg?w=700&q=90", "Peneliti utama di Northwestern University, Steven Jacobsen, menjelaskan bahwa lautan tanah yang sangat besar ini terdeteksi menggunakan jaringan 2000 seismograf yang tersebar di seluruh Amerika Serikat.\n" +
                    "\n" +
                    "Alat tersebut menangkap gelombang seismik yang dihasilkan oleh lebih dari 500 gempa bumi. Ketika gelombang ini merambat melalui Bumi, pergerakannya melalui batuan basah berbeda dengan batuan kering.\n" +
                    "\n" +
                    "Perbedaan kecepatan tersebutlah yang penting untuk mengidentifikasi keberadaan air dalam jumlah besar di bawah tanah.\n" +
                    "\n" +
                    "Konversi Ps amplitudo positif yang digunakan sebagai instrumen analisisnya, dengan jelas menentukan peningkatan kecepatan mendadak dengan kedalaman 660 kilometer di bawah mantel bumi.\n" +
                    "\n" +
                    "Dalam penelitian Jacobsen, dinyatakan kepadatan lautan air di dekat bagian atas mantel bawah tidak diketahui secara pasti, tetapi terdapat kemungkinan besar terdapat lautan air di bagian atas mantel bawah. Oleh karena itu Jacobsen dan rekan-rekan penelitinya memperkirakan bahwa penurunan kecepatan yang digambarkan di bawah 660.\n" +
                    "\n" +
                    "Lelehan hidro yang menjadi air ini sedikit mengapung lalu meresap ke atas, mengembalikan H2O (air) ke zona transisi. Lelehan air ini stabil secara gravitasi dan tetap atau atau menyebar ke sekitarnya daripada mempertahankan korelasi dengan pola aliran vertikal yang sedang berlangsung. Maka dari itu dapat membentuk lautan yang luas."))
            beritaList!!.add(BeritaData("Misteri Hilangnya Pendengaran Komposer Beethoven Akhirnya Terpecahkan!", "Ludwig van Beethoven bukanlah nama yang asing bagi pecinta musik klasik. Tetapi, alasan komposer itu kehilangan pendengaran masih menjadi misteri, sampai dipecahkan oleh para ilmuwan.", "https://akcdn.detik.net.id/community/media/visual/2021/02/23/beethoven-3_43.jpeg?w=700&q=90", "Para peneliti menganalisis DNA pada dua helai rambut komposer Jerman yang terautentikasi dan menemukan bahwa rambut tersebut mengandung timbal dengan konsentrasi yang sangat tinggi.\n" +
                    "\n" +
                    "Satu helai rambut mengandung 380 mikrogram timbal per gram rambut, sedangkan helai rambut kedua mengandung 258 mikrogram per gram rambut. Sebagai informasi, kadar normal saat ini mendekati 4 mikrogram atau kurang.\n" +
                    "\n" +
                    "Rambutnya juga mengandung arsenik 13 kali lipat dari kadar normal dan empat kali lipat kadar merkuri pada umumnya\n" +
                    "\n" +
                    "\"Ini adalah nilai tertinggi pada rambut yang pernah saya lihat,\" kata rekan penulis studi Paul Jannetto , ahli patologi di Mayo Clinic, dalam Live Science dikutip Kamis (16/5/2025).\n" +
                    "\n" +
                    "Tingginya kadar logam beracun ini dapat menjelaskan mengapa Beethoven mengalami sejumlah penyakit. Di samping kehilangan pendengaran, Beethoven juga menderita masalah pencernaan dan mengalami setidaknya dua episode penyakit kuning, gejala penyakit hati.\n" +
                    "\n" +
                    "Meskipun kadar timbal yang tinggi dikaitkan dengan masalah pencernaan, hati, serta penurunan pendengaran, namun kecil kemungkinan bahwa kadar timbal yang cukup tinggi menjadi satu-satunya penyebab kematian bagi komposer tersebut. Tingkat paparan timbal yang tinggi, kata para peneliti, mungkin berkontribusi pada penyakit yang terdokumentasi yang menjangkiti sebagian besar hidupnya."))
        }
    }
}
