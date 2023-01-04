package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!! // !! без проверки на null

    val filmsDataBase = listOf(
        Film("Женщина-Халк",R.drawable.movie1,"Дженнифер Уолтерс ведет сложную жизнь одинокого 30-летнего адвоката, который также является зеленым Халком со сверхспособностями ростом 6 футов 7 дюймов"),
        Film("Миссис Харрис едет в Париж",R.drawable.movie2,"Овдовевшая уборщица из Лондона 1950-х годов безумно влюбляется в платье Dior от кутюр и решает, что у нее должно быть свое собственное"),
        Film("Тор: Любовь и гром",R.drawable.movie3,"Тор обращается за помощью к Валькирии, Коргу и бывшей девушке Джейн Фостер, чтобы сразиться с Горром, богом-мясником, который намеревается уничтожить богов"),
        Film("Андор",R.drawable.movie4,"В эпоху, полную опасностей, обмана и интриг, Кассиан встанет на путь, которому суждено превратить его в героя-мятежника"),
        Film("Нет",R.drawable.movie5,"Жители одинокого ущелья во внутренней части Калифорнии стали свидетелями жуткого и леденящего душу открытия"),
        Film("Отомсти за меня",R.drawable.movie6,"Дреа и Элеонора соглашаются преследовать хулиганов друг друга"),
        Film("Бегущие по краю",R.drawable.movie7,"Уличный ребенок, пытающийся выжить в городе будущего, помешанном на технологиях и модификациях тела. Имея все, что можно потерять, он решает остаться в живых, став наемником-преступником, также известным как киберпанк"),
        Film("Аватар: Путь воды ",R.drawable.movie8,"Джейк Салли живет со своей новоиспеченной семьей на планете Пандора. Как только знакомая угроза возвращается, чтобы завершить начатое ранее, Джейк должен работать с Нейтири и армией расы На'ви, чтобы защитить свою планету"),
        Film("Быстрее пули ",R.drawable.movie9,"Пятеро убийц на борту сверхскоростного пассажирского экспресса обнаруживают, что у их миссий есть что-то общее")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //находим наш RV
        binding.mainRecycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager.
            // Везде, где у нас передавался контекст и мы указывали в активити this, во фрагменте мы должны передавать контекст при помощи метода requireContext()
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}