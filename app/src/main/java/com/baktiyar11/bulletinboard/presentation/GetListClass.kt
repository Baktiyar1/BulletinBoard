package com.baktiyar11.bulletinboard.presentation

import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.baktiyar11.bulletinboard.domain.models.category.transport.TransportModel
import java.util.*
import kotlin.collections.ArrayList

class GetListClass {
    private val idList: MutableList<Int> = mutableListOf()

    fun addAllTransportModel(): ArrayList<TransportModel> {

        val transportModelList: ArrayList<TransportModel> = arrayListOf()

        // Add Model Acura
        val idAcura: Int = checkId()
        val acuraModel = TransportModel(transportModelId = idAcura,
            transportModelName = "Acura",
            transportModelIcon = R.drawable.acura)
        transportModelList.add(0, acuraModel)

        // Add Model Alfa Romeo
        val idAlfaRomeo: Int = checkId()
        val alfaRomeoModel = TransportModel(transportModelId = idAlfaRomeo,
            transportModelName = "Alfa Romeo",
            transportModelIcon = R.drawable.alfaromeo)
        transportModelList.add(1, alfaRomeoModel)

        // Add Model Alpina
        val idAlpina: Int = checkId()
        val alpinaModel = TransportModel(transportModelId = idAlpina,
            transportModelName = "Alpina",
            transportModelIcon = R.drawable.alpina)
        transportModelList.add(2, alpinaModel)

        // Add Model Audi
        val idAudi: Int = checkId()
        val audiModel = TransportModel(transportModelId = idAudi,
            transportModelName = "Audi",
            transportModelIcon = R.drawable.audi)
        transportModelList.add(3, audiModel)

        // Add Model Bentley
        val idBentley: Int = checkId()
        val bentleyModel = TransportModel(transportModelId = idBentley,
            transportModelName = "Bentley",
            transportModelIcon = R.drawable.bentley)
        transportModelList.add(4, bentleyModel)

        // Add Model BMV
        val idBMV: Int = checkId()
        val bmvModel = TransportModel(transportModelId = idBMV,
            transportModelName = "BMV",
            transportModelIcon = R.drawable.bmw)
        transportModelList.add(5, bmvModel)

        // Add Model BYD
        val idBYD: Int = checkId()
        val bydModel = TransportModel(transportModelId = idBYD,
            transportModelName = "BYD",
            transportModelIcon = R.drawable.byd)
        transportModelList.add(6, bydModel)

        // Add Model Cadillac
        val idCadillac: Int = checkId()
        val cadillacModel = TransportModel(transportModelId = idCadillac,
            transportModelName = "Cadillac",
            transportModelIcon = R.drawable.cadillac)
        transportModelList.add(7, cadillacModel)

        // Add Model Cherry
        val idChery: Int = checkId()
        val cheryModel = TransportModel(transportModelId = idChery,
            transportModelName = "Cherry",
            transportModelIcon = R.drawable.cherry)
        transportModelList.add(8, cheryModel)

        // Add Model Chevrolet
        val idChevrolet: Int = checkId()
        val chevroletModel = TransportModel(transportModelId = idChevrolet,
            transportModelName = "Chevrolet",
            transportModelIcon = R.drawable.chevrolet)
        transportModelList.add(9, chevroletModel)

        // Add Model Chrysler
        val idChrysler: Int = checkId()
        val chryslerModel = TransportModel(transportModelId = idChrysler,
            transportModelName = "Chrysler",
            transportModelIcon = R.drawable.chrysler)
        transportModelList.add(10, chryslerModel)

        // Add Model Citroen
        val idCitroen: Int = checkId()
        val citroenModel = TransportModel(transportModelId = idCitroen,
            transportModelName = "Citroen",
            transportModelIcon = R.drawable.citraon)
        transportModelList.add(11, citroenModel)

        // Add Model Daewoo
        val idDaewoo: Int = checkId()
        val daewooModel = TransportModel(transportModelId = idDaewoo,
            transportModelName = "Daewoo",
            transportModelIcon = R.drawable.daewoo)
        transportModelList.add(12, daewooModel)

        // Add Model Daihatsu
        val idDaihatsu: Int = checkId()
        val daihatsuModel = TransportModel(transportModelId = idDaihatsu,
            transportModelName = "Daihatsu",
            transportModelIcon = R.drawable.daihatsu)
        transportModelList.add(13, daihatsuModel)

        // Add Model Dodge
        val idDodge: Int = checkId()
        val dodgeModel = TransportModel(transportModelId = idDodge,
            transportModelName = "Dodge",
            transportModelIcon = R.drawable.dodge)
        transportModelList.add(14, dodgeModel)

        // Add Model Dong Feng
        val idDongFeng: Int = checkId()
        val dongFengModel = TransportModel(transportModelId = idDongFeng,
            transportModelName = "Dong Feng",
            transportModelIcon = R.drawable.dongfeng)
        transportModelList.add(15, dongFengModel)

        // Add Model Fiat
        val idFiat: Int = checkId()
        val fiatModel = TransportModel(transportModelId = idFiat,
            transportModelName = "Fiat",
            transportModelIcon = R.drawable.fiat)
        transportModelList.add(16, fiatModel)

        // Add Model Ford
        val idFord: Int = checkId()
        val fordModel = TransportModel(transportModelId = idFord,
            transportModelName = "Ford",
            transportModelIcon = R.drawable.ford)
        transportModelList.add(17, fordModel)

        // Add Model Geekly
        val idGeekly: Int = checkId()
        val geeklyModel = TransportModel(transportModelId = idGeekly,
            transportModelName = "Geekly",
            transportModelIcon = R.drawable.geekly)
        transportModelList.add(18, geeklyModel)

        // Add Model GMC
        val idGMC: Int = checkId()
        val gmcModel = TransportModel(transportModelId = idGMC,
            transportModelName = "GMC",
            transportModelIcon = R.drawable.gmc)
        transportModelList.add(19, gmcModel)

        // Add Model Great Wall
        val idGreatWall: Int = checkId()
        val greatWallModel = TransportModel(transportModelId = idGreatWall,
            transportModelName = "Great Wall",
            transportModelIcon = R.drawable.greatwall)
        transportModelList.add(20, greatWallModel)

        // Add Model Honda
        val idHonda: Int = checkId()
        val hondaModel = TransportModel(transportModelId = idHonda,
            transportModelName = "Honda",
            transportModelIcon = R.drawable.honda)
        transportModelList.add(21, hondaModel)

        // Add Model Hummer
        val idHummer: Int = checkId()
        val hummerModel = TransportModel(transportModelId = idHummer,
            transportModelName = "Hummer",
            transportModelIcon = R.drawable.hummer)
        transportModelList.add(22, hummerModel)

        // Add Model Hyundai
        val idHyundai: Int = checkId()
        val hyundaiModel = TransportModel(transportModelId = idHyundai,
            transportModelName = "Hyundai",
            transportModelIcon = R.drawable.hyundai)
        transportModelList.add(23, hyundaiModel)

        // Add Model Infinity
        val idInfinity: Int = checkId()
        val infinityModel = TransportModel(transportModelId = idInfinity,
            transportModelName = "Infinity",
            transportModelIcon = R.drawable.infinity)
        transportModelList.add(24, infinityModel)

        // Add Model Isuzu
        val idIsuzu: Int = checkId()
        val isuzuModel = TransportModel(transportModelId = idIsuzu,
            transportModelName = "Isuzu",
            transportModelIcon = R.drawable.isuzu)
        transportModelList.add(25, isuzuModel)

        // Add Model Jaguar
        val idJaguar: Int = checkId()
        val jaguarModel = TransportModel(transportModelId = idJaguar,
            transportModelName = "Jaguar",
            transportModelIcon = R.drawable.jaguar)
        transportModelList.add(26, jaguarModel)

        // Add Model Jeep
        val idJeep: Int = checkId()
        val jeepModel = TransportModel(transportModelId = idJeep,
            transportModelName = "Jeep",
            transportModelIcon = R.drawable.jeep)
        transportModelList.add(27, jeepModel)

        // Add Model Kia
        val idKia: Int = checkId()
        val kiaModel = TransportModel(transportModelId = idKia,
            transportModelName = "Kia",
            transportModelIcon = R.drawable.kia)
        transportModelList.add(28, kiaModel)

        // Add Model Lamborghini
        val idLamborghini: Int = checkId()
        val lamborghiniModel = TransportModel(transportModelId = idLamborghini,
            transportModelName = "Lamborghini",
            transportModelIcon = R.drawable.lamborghini)
        transportModelList.add(29, lamborghiniModel)

        // Add Model Land Rover
        val idLandRover: Int = checkId()
        val landRoverModel = TransportModel(transportModelId = idLandRover,
            transportModelName = "Land Rover",
            transportModelIcon = R.drawable.landrover)
        transportModelList.add(30, landRoverModel)

        // Add Model Lexus
        val idLexus: Int = checkId()
        val lexusModel = TransportModel(transportModelId = idLexus,
            transportModelName = "Lexus",
            transportModelIcon = R.drawable.lexus)
        transportModelList.add(31, lexusModel)

        // Add Model Lifan
        val idLifan: Int = checkId()
        val lifanModel = TransportModel(transportModelId = idLifan,
            transportModelName = "Lifan",
            transportModelIcon = R.drawable.lifan)
        transportModelList.add(32, lifanModel)

        // Add Model Lincoln
        val idLincoln: Int = checkId()
        val lincolnModel = TransportModel(transportModelId = idLincoln,
            transportModelName = "Lincoln",
            transportModelIcon = R.drawable.lincoln)
        transportModelList.add(33, lincolnModel)

        // Add Model Mazda
        val idMazda: Int = checkId()
        val mazdaModel = TransportModel(transportModelId = idMazda,
            transportModelName = "Mazda",
            transportModelIcon = R.drawable.mazda)
        transportModelList.add(34, mazdaModel)

        // Add Model Mercedes-Benz
        val idMercedesBenz: Int = checkId()
        val mercedesBenzModel = TransportModel(transportModelId = idMercedesBenz,
            transportModelName = "Mercedes-Benz",
            transportModelIcon = R.drawable.mercedes_benz)
        transportModelList.add(35, mercedesBenzModel)

        // Add Model MINI
        val idMini: Int = checkId()
        val miniModel = TransportModel(transportModelId = idMini,
            transportModelName = "MINI",
            transportModelIcon = R.drawable.mini)
        transportModelList.add(36, miniModel)

        // Add Model Mitsubishi
        val idMitsubishi: Int = checkId()
        val mitsubishiModel = TransportModel(transportModelId = idMitsubishi,
            transportModelName = "Mitsubishi",
            transportModelIcon = R.drawable.mitsubishi)
        transportModelList.add(37, mitsubishiModel)

        // Add Model Nissan
        val idNissan: Int = checkId()
        val nissanModel = TransportModel(transportModelId = idNissan,
            transportModelName = "Nissan",
            transportModelIcon = R.drawable.nissan)
        transportModelList.add(38, nissanModel)

        // Add Model Opel
        val idOpel: Int = checkId()
        val opelModel = TransportModel(transportModelId = idOpel,
            transportModelName = "Opel",
            transportModelIcon = R.drawable.opel)
        transportModelList.add(39, opelModel)

        // Add Model Peugeot
        val idPeugeot: Int = checkId()
        val peugeotModel = TransportModel(transportModelId = idPeugeot,
            transportModelName = "Peugeot",
            transportModelIcon = R.drawable.peugeot)
        transportModelList.add(40, peugeotModel)

        // Add Model Porsche
        val idPorsche: Int = checkId()
        val porscheModel = TransportModel(transportModelId = idPorsche,
            transportModelName = "Porsche",
            transportModelIcon = R.drawable.porsche)
        transportModelList.add(41, porscheModel)

        // Add Model Ravon
        val idRavon: Int = checkId()
        val ravonModel = TransportModel(transportModelId = idRavon,
            transportModelName = "Ravon",
            transportModelIcon = R.drawable.ravon)
        transportModelList.add(42, ravonModel)

        // Add Model Renault
        val idRenault: Int = checkId()
        val renaultModel = TransportModel(transportModelId = idRenault,
            transportModelName = "Renault",
            transportModelIcon = R.drawable.renault)
        transportModelList.add(43, renaultModel)

        // Add Model Rover
        val idRover: Int = checkId()
        val roverModel = TransportModel(transportModelId = idRover,
            transportModelName = "Rover",
            transportModelIcon = R.drawable.rover)
        transportModelList.add(44, roverModel)

        // Add Model Saab
        val idSaab: Int = checkId()
        val saabModel = TransportModel(transportModelId = idSaab,
            transportModelName = "Saab",
            transportModelIcon = R.drawable.saab)
        transportModelList.add(45, saabModel)

        // Add Model Saturn
        val idSaturn: Int = checkId()
        val saturnModel = TransportModel(transportModelId = idSaturn,
            transportModelName = "Saturn",
            transportModelIcon = R.drawable.saturn)
        transportModelList.add(46, saturnModel)

        // Add Model Scion
        val idScion: Int = checkId()
        val scionModel = TransportModel(transportModelId = idScion,
            transportModelName = "Scion",
            transportModelIcon = R.drawable.scion)
        transportModelList.add(47, scionModel)

        // Add Model SEAT
        val idSeat: Int = checkId()
        val seatModel = TransportModel(transportModelId = idSeat,
            transportModelName = "SEAT",
            transportModelIcon = R.drawable.seat)
        transportModelList.add(48, seatModel)

        // Add Model Scoda
        val idScoda: Int = checkId()
        val scodaModel = TransportModel(transportModelId = idScoda,
            transportModelName = "Scoda",
            transportModelIcon = R.drawable.scoda)
        transportModelList.add(49, scodaModel)

        // Add Model Scoda
        val idSsangYong: Int = checkId()
        val ssangYongModel = TransportModel(transportModelId = idSsangYong,
            transportModelName = "SsangYong",
            transportModelIcon = R.drawable.ssangyoung)
        transportModelList.add(50, ssangYongModel)

        // Add Model Subaru
        val idSubaru: Int = checkId()
        val subaruModel = TransportModel(transportModelId = idSubaru,
            transportModelName = "Subaru",
            transportModelIcon = R.drawable.subaru)
        transportModelList.add(51, subaruModel)

        // Add Model Suzuki
        val idSuzuki: Int = checkId()
        val suzukiModel = TransportModel(transportModelId = idSuzuki,
            transportModelName = "Suzuki",
            transportModelIcon = R.drawable.tofas)
        transportModelList.add(52, suzukiModel)

        // Add Model Tofas
        val idTofas: Int = checkId()
        val tofasModel = TransportModel(transportModelId = idTofas,
            transportModelName = "Tofas",
            transportModelIcon = R.drawable.suzuki)
        transportModelList.add(53, tofasModel)

        // Add Model Toyota
        val idToyota: Int = checkId()
        val toyotaModel = TransportModel(transportModelId = idToyota,
            transportModelName = "Toyota",
            transportModelIcon = R.drawable.toyota)
        transportModelList.add(54, toyotaModel)

        // Add Model Other
        val idOther: Int = checkId()
        val otherModel = TransportModel(transportModelId = idOther,
            transportModelName = "Other",
            transportModelIcon = R.drawable.transport)
        transportModelList.add(55, otherModel)

        return transportModelList
    }

    fun addAllSubTransportCategory() : ArrayList<String> {
        val subTransportCategory: ArrayList<String> = arrayListOf()
        subTransportCategory.add(index = 0, element = "PASSENGER CAR")
        subTransportCategory.add(index = 1, element = "AUTO PARTS AND ACCESSORIES")
        subTransportCategory.add(index = 2, element = "MOTORCYCLES AND MOpedES")
        subTransportCategory.add(index = 3, element = "MOTOR PARTS AND ACCESSORIES")
        subTransportCategory.add(index = 4, element =  "CARGO AND AGRICULTURAL TRANSPORT")
        subTransportCategory.add(index = 5, element = "SPARE PARTS FOR CARGO AND AGRICULTURAL TRANSPORT")
        subTransportCategory.add(index = 6, element = "WATER TRANSPORT")
        subTransportCategory.add(index = 7, element =  "OTHER TRANSPORT")
        return subTransportCategory
    }

    fun addAllCategory(): ArrayList<Category> {

        val categoryList: ArrayList<Category> = arrayListOf()

        // Add category TRANSPORT
        val idTransport: Int = checkId()
        val transport = Category(idCategoryRoom = idTransport,
            categoryName = "TRANSPORT",
            categoryDescription = "Automobiles of Kyrgyzstan, auto accessories, auto parts",
            categoryIcon = R.drawable.transport)
        categoryList.add(0, transport)

        // Add category REAL ESTATE
        val idRealEstate: Int = checkId()
        val realEstate = Category(idRealEstate,
            "REAL ESTATE",
            "Purchase, sale and rental of real estate throughout Kyrgyzstan",
            R.drawable.real_estate)
        categoryList.add(1, realEstate)

        // Add category TAXI
        val idTaxi: Int = checkId()
        val taxi = Category(idTaxi,
            "TAXI",
            "Taxi services throughout Kyrgyzstan",
            R.drawable.taxi)
        categoryList.add(2, taxi)

        // Add category ELECTRONICS
        val idElectronic: Int = checkId()
        val electronic = Category(idElectronic,
            "ELECTRONICS",
            "Large hypermarket of new and used electronics in Kyrgyzstan",
            R.drawable.electronic)
        categoryList.add(3, electronic)

        // Add category SERVICES
        val idService: Int = checkId()
        val service = Category(idService,
            "SERVICES",
            "Repair, service and other services throughout Kyrgyzstan",
            R.drawable.services)
        categoryList.add(4, service)

        // Add category WORK
        val idWork: Int = checkId()
        val work = Category(idWork,
            "WORK",
            "The most current vacancies and qualified employees throughout Kyrgyzstan",
            R.drawable.work)
        categoryList.add(5, work)

        // add category PERSONAL ITEMS
        val idPersonalItems: Int = checkId()
        val personalItems = Category(idPersonalItems,
            "PERSONAL ITEMS",
            "Second hand and products from the best manufacturers in the world and Kyrgyzstan",
            R.drawable.personal_items)
        categoryList.add(6, personalItems)

        // add category ANIMALS
        val idAnimals: Int = checkId()
        val animals = Category(idCategoryRoom = idAnimals,
            categoryName = "ANIMALS",
            categoryDescription = "Companion animals that take up leisure, provide pleasure and with whom you can communicate",
            categoryIcon = R.drawable.animals)
        categoryList.add(7, animals)

        // add category SPORT AND HOBBIES
        val idSportAndHobbies: Int = checkId()
        val sportAndHobbies = Category(idSportAndHobbies,
            "SPORT AND HOBBIES",
            "Everything for a sporty lifestyle",
            R.drawable.sport_and_hobbies)
        categoryList.add(8, sportAndHobbies)

        // add category MEDICAL PRODUCTS
        val idMedicalProducts: Int = checkId()
        val medicalProducts = Category(idMedicalProducts,
            "MEDICAL PRODUCTS",
            "Medicines and medical products from trusted manufacturers",
            R.drawable.medical_products)
        categoryList.add(9, medicalProducts)

        // add category CHILDREN'S WORLD
        val idChildrenWord: Int = checkId()
        val childrenWord = Category(idChildrenWord,
            "CHILDREN'S WORLD",
            "Everything for children",
            R.drawable.kids)
        categoryList.add(10, childrenWord)

        // add category MEDICAL PRODUCTS
        val idGiveForFree: Int = checkId()
        val giveForFree = Category(idGiveForFree,
            "GIVE FOR FREE",
            "All that is here you can get FREE",
            R.drawable.give_for_free)
        categoryList.add(11, giveForFree)

        return categoryList
    }

    private fun checkId(): Int {
        val newId = Random().nextInt(9999999)
        idList.forEach { id ->
            if (id == newId) checkId()
            else idList.add(newId)
        }
        return newId
    }
}