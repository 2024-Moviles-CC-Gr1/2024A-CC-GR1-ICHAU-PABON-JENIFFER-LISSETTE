package com.example.a2024accgr1jlip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var postsRecyclerView: RecyclerView
    private lateinit var storiesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postsRecyclerView = findViewById(R.id.postsRecyclerView)
        storiesRecyclerView = findViewById(R.id.storiesRecyclerView)

        setupPostsRecyclerView()
        setupStoriesRecyclerView()
    }

    private fun setupPostsRecyclerView() {
        val posts = listOf(
            Post("Juan Díaz", "https://i.pinimg.com/236x/12/5d/cd/125dcd8ee7d52a9e84e8f0a016e9dbdd.jpg", "Jajaja \uD83D\uDE02\uD83E\uDD23 ", "https://deseguridadehigiene.com.ar/wp-content/uploads/2023/10/WhatsApp-Image-2023-10-17-at-22.55.58-2.jpeg"),
            Post("Ana Torres", "https://i.pinimg.com/736x/a7/09/2e/a7092e6830b8f07cfe0eab6a294e7c3d.jpg", "\uD83D\uDCF8 ¡Miren esta foto de hace 4 años! Los tiempos cambian, pero los recuerdos permanecen. #TBT #Recuerdos", "https://voiz.com.co/wp-content/uploads/2020/02/15-anos-elegantes-3.jpg"),
            Post("Paula Ramírez", "https://i.pinimg.com/236x/ef/f0/eb/eff0eb4c2f2c44cd61b3ae7a8b41bfb3.jpg", "\uD83D\uDE4F \uD83D\uDC69\u200D\uD83C\uDF93 Hoy quiero agradecer a todas las personas maravillosas en mi vida que me han apoyado y motivado. Sin ustedes, nada de esto sería posible.", "https://st2.depositphotos.com/1037987/5934/i/950/depositphotos_59344931-stock-photo-student-and-parents-celebrate-graduation.jpg")
        )

        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        postsRecyclerView.adapter = PostAdapter(posts)
    }

    private fun setupStoriesRecyclerView() {
        val stories = listOf(
            Story("Jeniffer", "https://secrecyjewels.es/blog/wp-content/uploads/2022/10/esencia-de-una-persona.jpg", "https://t4.ftcdn.net/jpg/07/06/72/43/360_F_706724318_SilctpdLGPefFMlHGTRwxE8of2AveaIv.jpg"),
            Story("Erick", "https://www.okchicas.com/wp-content/uploads/2017/10/hombres-guapos-amsterdam.jpg", "https://www.elcomercio.com/wp-content/uploads/2022/02/Museo-700x391.jpg"),
            Story("Lissette", "https://www.caracteristicasdel.com/wp-content/uploads/2020/09/Caracteristicas-de-la-Persona.jpg", "https://cdn0.bodas.net/article/2170/original/1280/png/100712-es-editorial-2.jpeg"),
            Story("Sebastian", "https://t2.uc.ltmcdn.com/es/posts/6/5/8/por_que_los_hombres_tienen_barba_31856_600_square.jpg", "https://i.blogs.es/6a347b/comida/840_560.jpg") ,
            Story("Cecilia", "https://cdn-3.expansion.mx/infographic/2023/03/16-18/53/14-00000186-e605-dbf7-a5ae-f605a5a20002-default/img/ap_movil/04mob-karen-flores.jpg", "https://as2.ftcdn.net/v2/jpg/01/21/24/71/1000_F_121247110_9Zz9K9qkZhHFE6ytuMfmy1gyZa4mqcdp.jpg"),
            Story("Carlos", "https://peinados.art/wp-content/uploads/2024/06/Desenfadado-Grunge.jpeg", "https://clubmac.mx/wp-content/uploads/2019/11/IMG_3953-1024x1003.jpg")
        )

        storiesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        storiesRecyclerView.adapter = StoryAdapter(stories)
    }
}