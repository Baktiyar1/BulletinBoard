package com.baktiyar11.bulletinboard.presentation.details.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.baktiyar11.bulletinboard.data.RetrofitBuilder
import com.baktiyar11.bulletinboard.databinding.ActivityCategoryDetailsBinding
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.baktiyar11.bulletinboard.domain.models.category.animals.Animals
import com.baktiyar11.bulletinboard.domain.models.category.childrenWord.ChildrenWord
import com.baktiyar11.bulletinboard.domain.models.category.electronics.Electronics
import com.baktiyar11.bulletinboard.domain.models.category.giveForFree.GiveForFree
import com.baktiyar11.bulletinboard.domain.models.category.medicalProducts.MedicalProducts
import com.baktiyar11.bulletinboard.domain.models.category.personalItems.PersonalItems
import com.baktiyar11.bulletinboard.domain.models.category.realEstate.RealEstate
import com.baktiyar11.bulletinboard.domain.models.category.services.Services
import com.baktiyar11.bulletinboard.domain.models.category.sportAndHobbies.SportAndHobbies
import com.baktiyar11.bulletinboard.domain.models.category.taxi.Taxi
import com.baktiyar11.bulletinboard.domain.models.category.transport.Transport
import com.baktiyar11.bulletinboard.domain.models.category.work.Work
import com.baktiyar11.bulletinboard.presentation.details.adapter.*
import com.baktiyar11.bulletinboard.presentation.main.ui.activity.AnnouncementListsActivity
import com.baktiyar11.bulletinboard.utils.CATEGORY_KEY
import com.baktiyar11.bulletinboard.utils.PRODUCT_KEY
import com.baktiyar11.bulletinboard.utils.intentClearTask
import com.baktiyar11.bulletinboard.utils.toast
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsCategoryActivity : AppCompatActivity() {

    private val binding: ActivityCategoryDetailsBinding by lazy {
        ActivityCategoryDetailsBinding.inflate(layoutInflater)
    }
    private var transportList: MutableList<Transport> = mutableListOf()
    private var realEstateList: MutableList<RealEstate> = mutableListOf()
    private var taxiList: MutableList<Taxi> = mutableListOf()
    private var electronicsList: MutableList<Electronics> = mutableListOf()
    private var servicesList: MutableList<Services> = mutableListOf()
    private var workList: MutableList<Work> = mutableListOf()
    private var personalItemsList: MutableList<PersonalItems> = mutableListOf()
    private var animalsList: MutableList<Animals> = mutableListOf()
    private var sportAndHobbiesList: MutableList<SportAndHobbies> = mutableListOf()
    private var medicalProductsList: MutableList<MedicalProducts> = mutableListOf()
    private var childrenWordList: MutableList<ChildrenWord> = mutableListOf()
    private var giveForFreeList: MutableList<GiveForFree> = mutableListOf()
    private val category: Category by lazy {
        intent!!.extras!!.getSerializable(CATEGORY_KEY) as Category
    }
    private val transportAdapter: TransportAdapter by lazy {
        TransportAdapter(object : ItemClickListenerTransport {
            override fun showDetailsTransport(transport: Transport) {
                val intent =
                    Intent(this@DetailsCategoryActivity, DetailsProductActivity::class.java)
                intent.putExtra(PRODUCT_KEY, transport)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }
    private val realEstateAdapter: RealEstateAdapter by lazy {
        RealEstateAdapter(object : ItemClickListenerRealEstate {
            override fun showDetailsRealEstate(realEstate: RealEstate) {
                val intent =
                    Intent(this@DetailsCategoryActivity, DetailsProductActivity::class.java)
                intent.putExtra(PRODUCT_KEY, realEstate)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }
    private val taxiAdapter: TaxiAdapter by lazy {
        TaxiAdapter(object : ItemClickListenerTaxi {
            override fun showDetailsTaxi(taxi: Taxi) {
                val intent =
                    Intent(this@DetailsCategoryActivity, DetailsProductActivity::class.java)
                intent.putExtra(PRODUCT_KEY, taxi)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }
    private val electronicsAdapter: ElectronicsAdapter by lazy {
        ElectronicsAdapter(object : ItemClickListenerElectronics {
            override fun showDetailsElectronics(electronics: Electronics) {
                val intent =
                    Intent(this@DetailsCategoryActivity, DetailsProductActivity::class.java)
                intent.putExtra(PRODUCT_KEY, electronics)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }
    private val servicesAdapter: ServicesAdapter by lazy {
        ServicesAdapter(object : ItemClickListenerServices {
            override fun showDetailsServices(services: Services) {
                val intent =
                    Intent(this@DetailsCategoryActivity, DetailsProductActivity::class.java)
                intent.putExtra(PRODUCT_KEY, services)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }
    private val workAdapter: WorkAdapter by lazy {
        WorkAdapter(object : ItemClickListenerWork {
            override fun showDetailsWork(work: Work) {
                val intent =
                    Intent(this@DetailsCategoryActivity, DetailsProductActivity::class.java)
                intent.putExtra(PRODUCT_KEY, work)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }
    private val personalItemsAdapter: PersonalItemsAdapter by lazy {
        PersonalItemsAdapter(object : ItemClickListenerPersonalItems {
            override fun showDetailsPersonalItems(personalItems: PersonalItems) {
                val intent =
                    Intent(this@DetailsCategoryActivity, DetailsProductActivity::class.java)
                intent.putExtra(PRODUCT_KEY, personalItems)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }
    private val animalsAdapter: AnimalsAdapter by lazy {
        AnimalsAdapter(object : ItemClickListenerAnimals {
            override fun showDetailsAnimals(animals: Animals) {
                val intent =
                    Intent(this@DetailsCategoryActivity, DetailsProductActivity::class.java)
                intent.putExtra(PRODUCT_KEY, animals)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }
    private val sportAndHobbiesAdapter: SportAndHobbiesAdapter by lazy {
        SportAndHobbiesAdapter(object : ItemClickListenerSportAndHobbies {
            override fun showDetailsSportAndHobbies(sportAndHobbies: SportAndHobbies) {
                val intent =
                    Intent(this@DetailsCategoryActivity, DetailsProductActivity::class.java)
                intent.putExtra(PRODUCT_KEY, sportAndHobbies)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }
    private val medicalProductsAdapter: MedicalProductsAdapter by lazy {
        MedicalProductsAdapter(object : ItemClickListenerMedicalProducts {
            override fun showDetailsMedicalProducts(medicalProducts: MedicalProducts) {
                val intent =
                    Intent(this@DetailsCategoryActivity, DetailsProductActivity::class.java)
                intent.putExtra(PRODUCT_KEY, medicalProducts)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }
    private val childrenWordAdapter: ChildrenWordAdapter by lazy {
        ChildrenWordAdapter(object : ItemClickListenerChildrenWord {
            override fun showDetailsChildrenWord(childrenWord: ChildrenWord) {
                val intent =
                    Intent(this@DetailsCategoryActivity, DetailsProductActivity::class.java)
                intent.putExtra(PRODUCT_KEY, childrenWord)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }
    private val giveForFreeAdapter: GiveForFreeAdapter by lazy {
        GiveForFreeAdapter(object : ItemClickListenerGiveForFree {
            override fun showDetailsGiveForFree(giveForFree: GiveForFree) {
                val intent =
                    Intent(this@DetailsCategoryActivity, DetailsProductActivity::class.java)
                intent.putExtra(PRODUCT_KEY, giveForFree)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            backMainMenu.setOnClickListener {
                intentClearTask(AnnouncementListsActivity())
            }

            detailsCategoryDescription.text = category.categoryDescription

            Picasso.get().load(category.categoryIcon).into(imageCategoryDetails)

            getAll()

            swipeLayout.setOnRefreshListener {
                getAll()
                swipeLayout.isRefreshing = false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getAll()
    }

    private fun getAll() {
        when (category.categoryName) {
            "TRANSPORT" -> getAllTransport(category)
            "REAL ESTATE" -> getAllRealEstate(category)
            "TAXI" -> getAllTaxi(category)
            "ELECTRONICS" -> getAllElectronics(category)
            "SERVICES" -> getAllServices(category)
            "WORK" -> getAllWork(category)
            "PERSONAL ITEMS" -> getAllPersonalItems(category)
            "ANIMALS" -> getAllAnimals(category)
            "SPORT AND HOBBIES" -> getAllSportAndHobbies(category)
            "MEDICAL PRODUCTS" -> getAllMedicalProducts(category)
            "CHILDREN WORLD" -> getAllChildrenWorld(category)
            "GIVE FOR FREE" -> getAllGiveForFree(category)
            else -> toast("Error! Try again later")
        }
    }

    private fun getAllTransport(category: Category) = lifecycleScope.launch(Dispatchers.IO) {
        val response =
            RetrofitBuilder.api.getAllTransport(id = "{\"category\":\"${category.categoryName}\"}")
        if (response?.body()?.results?.isEmpty() == true) {
            withContext(Dispatchers.Main) { toast("No ads!") }
        } else {
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful) {
                    transportList = response.body()!!.results.toMutableList()
                    transportAdapter.transportList = transportList
                    binding.recViewProduct.adapter = transportAdapter
                } else toast(response.message())
            }
        }
    }

    private fun getAllRealEstate(category: Category) = lifecycleScope.launch(Dispatchers.IO) {
        val response =
            RetrofitBuilder.api.getAllRealEstate(id = "{\"category\":\"${category.categoryName}\"}")
        if (response?.body()?.results?.isEmpty() == true) {
            withContext(Dispatchers.Main) { toast("No ads!") }
        }
        else {
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful) {
                    realEstateList = response.body()!!.results.toMutableList()
                    realEstateAdapter.realEstateList = realEstateList
                    binding.recViewProduct.adapter = realEstateAdapter
                } else toast(response.message())
            }
        }
    }

    private fun getAllTaxi(category: Category) = lifecycleScope.launch(Dispatchers.IO) {
        val response =
            RetrofitBuilder.api.getAllTaxi(id = "{\"category\":\"${category.categoryName}\"}")
        if (response?.body()?.results?.isEmpty() == true) toast("No ads!")
        else {
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful) {
                    taxiList = response.body()!!.results.toMutableList()
                    taxiAdapter.taxiList = taxiList
                    binding.recViewProduct.adapter = taxiAdapter
                } else toast(response.message())
            }
        }

    }

    private fun getAllElectronics(category: Category) = lifecycleScope.launch(Dispatchers.IO) {
        val response =
            RetrofitBuilder.api.getAllElectronics(id = "{\"category\":\"${category.categoryName}\"}")
        if (response?.body()?.results?.isEmpty() == true) toast("No ads!")
        else {
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful) {
                    electronicsList = response.body()!!.results.toMutableList()
                    electronicsAdapter.electronicsList = electronicsList
                    binding.recViewProduct.adapter = electronicsAdapter
                } else toast(response.message())
            }
        }
    }

    private fun getAllServices(category: Category) = lifecycleScope.launch(Dispatchers.IO) {
        val response =
            RetrofitBuilder.api.getAllServices(id = "{\"category\":\"${category.categoryName}\"}")
        if (response?.body()?.results?.isEmpty() == true) toast("No ads!")
        else {
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful) {
                    servicesList = response.body()!!.results.toMutableList()
                    servicesAdapter.servicesList = servicesList
                    binding.recViewProduct.adapter = servicesAdapter
                } else toast(response.message())
            }
        }
    }

    private fun getAllWork(category: Category) = lifecycleScope.launch(Dispatchers.IO) {
        val response =
            RetrofitBuilder.api.getAllWork(id = "{\"category\":\"${category.categoryName}\"}")
        if (response?.body()?.results?.isEmpty() == true) toast("No ads!")
        else {
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful) {
                    workList = response.body()!!.results.toMutableList()
                    workAdapter.workList = workList
                    binding.recViewProduct.adapter = workAdapter
                } else toast(response.message())
            }
        }
    }

    private fun getAllPersonalItems(category: Category) = lifecycleScope.launch(Dispatchers.IO) {
        val response =
            RetrofitBuilder.api.getAllPersonalItems(id = "{\"category\":\"${category.categoryName}\"}")
        if (response?.body()?.results?.isEmpty() == true) toast("No ads!")
        else {
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful) {
                    personalItemsList = response.body()!!.results.toMutableList()
                    personalItemsAdapter.personalItemsList = personalItemsList
                    binding.recViewProduct.adapter = personalItemsAdapter
                } else toast(response.message())
            }
        }
    }

    private fun getAllAnimals(category: Category) = lifecycleScope.launch(Dispatchers.IO) {
        val response =
            RetrofitBuilder.api.getAllAnimals(id = "{\"category\":\"${category.categoryName}\"}")
        if (response?.body()?.results?.isEmpty() == true) toast("No ads!")
        else {
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful) {
                    animalsList = response.body()!!.results.toMutableList()
                    animalsAdapter.animalsList = animalsList
                    binding.recViewProduct.adapter = animalsAdapter
                } else toast(response.message())
            }
        }
    }

    private fun getAllSportAndHobbies(category: Category) = lifecycleScope.launch(Dispatchers.IO) {
        val response =
            RetrofitBuilder.api.getAllSportAndHobbies(id = "{\"category\":\"${category.categoryName}\"}")
        if (response?.body()?.results?.isEmpty() == true) toast("No ads!")
        else {
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful) {
                    sportAndHobbiesList = response.body()!!.results.toMutableList()
                    sportAndHobbiesAdapter.sportAndHobbiesList = sportAndHobbiesList
                    binding.recViewProduct.adapter = sportAndHobbiesAdapter
                } else toast(response.message())
            }
        }
    }

    private fun getAllMedicalProducts(category: Category) = lifecycleScope.launch(Dispatchers.IO) {
        val response =
            RetrofitBuilder.api.getAllMedicalProducts(id = "{\"category\":\"${category.categoryName}\"}")
        if (response?.body()?.results?.isEmpty() == true) toast("No ads!")
        else {
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful) {
                    medicalProductsList = response.body()!!.results.toMutableList()
                    medicalProductsAdapter.medicalProductsList = medicalProductsList
                    binding.recViewProduct.adapter = medicalProductsAdapter
                } else toast(response.message())
            }
        }
    }

    private fun getAllChildrenWorld(category: Category) = lifecycleScope.launch(Dispatchers.IO) {
        val response =
            RetrofitBuilder.api.getAllChildrenWord(id = "{\"category\":\"${category.categoryName}\"}")
        if (response?.body()?.results?.isEmpty() == true) toast("No ads!")
        else {
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful) {
                    childrenWordList = response.body()!!.results.toMutableList()
                    childrenWordAdapter.childrenWordList = childrenWordList
                    binding.recViewProduct.adapter = childrenWordAdapter
                } else toast(response.message())
            }
        }
    }

    private fun getAllGiveForFree(category: Category) = lifecycleScope.launch(Dispatchers.IO) {
        val response =
            RetrofitBuilder.api.getAllGiveForFree(id = "{\"category\":\"${category.categoryName}\"}")
        if (response?.body()?.results?.isEmpty() == true) toast("No ads!")
        else {
            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful) {
                    giveForFreeList = response.body()!!.results.toMutableList()
                    giveForFreeAdapter.giveForFreeList = giveForFreeList
                    binding.recViewProduct.adapter = giveForFreeAdapter
                } else toast(response.message())
            }
        }
    }
}