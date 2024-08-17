package com.example.a2024accgr1jlip

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExploreActivity : AppCompatActivity() {
    private lateinit var dessertAdapter: DessertAdapter
    private val dessertList = mutableListOf<Dessert>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)

        val recyclerView = findViewById<RecyclerView>(R.id.dessertRecyclerView)
        dessertAdapter = DessertAdapter(dessertList) { dessert ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("DESSERT_ID", dessert.id)
            intent.putExtra("DESSERT_NAME", dessert.name)
            intent.putExtra("DESSERT_DESCRIPTION", dessert.description)
            intent.putExtra("DESSERT_PRICE", dessert.price)
            intent.putExtra("DESSERT_IMAGE", dessert.imageResId)
            startActivity(intent)
        }
        recyclerView.adapter = dessertAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        loadDesserts()
    }

    private fun loadDesserts() {
        // Sample data
        dessertList.add(Dessert(1, "Passionfruit Paradise", "A deeply rich and indulgent cake made with chocolate or cocoa powder, resulting in a dense and moist crumb. It’s often layered and frosted with a luscious chocolate ganache or buttercream, making it a decadent treat for chocolate lovers. Some versions include additional fillings like fruit preserves or whipped cream.", 30.50, R.mipmap.pastel1, 4.5f))
        dessertList.add(Dessert(2, "Blueberry Bliss", "A rich and creamy dessert made primarily with cream cheese, eggs, and sugar, set on a crunchy graham cracker or biscuit crust. The smooth, dense texture pairs perfectly with a variety of toppings like fresh berries, chocolate, or caramel sauce. It's a versatile cake that can be baked or prepared as a no-bake version, depending on the recipe.", 28.00, R.mipmap.pastel2, 4.2f))
        dessertList.add(Dessert(3, "Happy Birthday Cake", "A traditional American dessert featuring a flaky, buttery crust filled with tender, spiced apple slices. The apples are usually mixed with sugar, cinnamon, and sometimes a hint of nutmeg, giving it a warm, comforting flavor. It’s typically served warm, often accompanied by a scoop of vanilla ice cream or a dollop of whipped cream.", 29.00, R.mipmap.pastel3, 4.2f))
        dessertList.add(Dessert(4, "Three Milk Cake", "A delicately soft sponge cake soaked in a blend of evaporated milk, condensed milk, and heavy cream. This creates a moist, melt-in-your-mouth texture that’s rich and creamy. It's often topped with whipped cream and sometimes with fresh fruit like strawberries or cherries.", 25.00, R.mipmap.pastel4, 4.2f))
        dessertList.add(Dessert(5, "Strawberry Shortcake", "A light and airy cake layered with fresh strawberries and sweetened whipped cream. The cake itself is often a tender, slightly sweet sponge or biscuit, which soaks up the juices from the strawberries. It’s a refreshing dessert, perfect for showcasing the flavor of ripe, in-season strawberries.", 19.00, R.mipmap.pastel5, 4.2f))
        dessertList.add(Dessert(6, "Black Forest Cake", "A luxurious German chocolate cake made with layers of chocolate sponge, tart cherries, and whipped cream. The cake is usually soaked with kirsch (a cherry brandy) to enhance its flavor and topped with chocolate shavings and whole cherries. This combination of rich chocolate, creamy whipped cream, and fruity cherries makes it a complex and indulgent dessert.\n" +
                "\n", 38.00, R.mipmap.pastel6, 4.2f))

        dessertAdapter.notifyDataSetChanged()
    }
}