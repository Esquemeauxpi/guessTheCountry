package ad.adaam.thequizapp


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.allOf
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class Welcomepage {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun welcomepage() {
        val textView = onView(
            allOf(
                withText("Quiz App!"),
                withParent(
                    withParent(
                        allOf(
                            withId(android.R.id.content),
                            withParent(
                                allOf(
                                    withId(com.google.android.material.R.id.action_bar_root),
                                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java)))
                                )
                            )
                        )
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Quiz App!")))

        val textView2 = onView(
            allOf(
                withText("Quiz App!"),
                withParent(
                    withParent(
                        allOf(
                            withId(android.R.id.content),
                            withParent(
                                allOf(
                                    withId(com.google.android.material.R.id.action_bar_root),
                                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java)))
                                )
                            )
                        )
                    )
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Quiz App!")))

        val textView3 = onView(
            allOf(
                withText("Welcome"),
                withParent(
                    withParent(
                        withParent(
                            withParent(
                                allOf(
                                    withId(android.R.id.content),
                                    withParent(withId(com.google.android.material.R.id.action_bar_root))
                                )
                            )
                        )
                    )
                ),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("Welcome")))

        val textView4 = onView(
            allOf(
                withText("Please enter your name."),
                withParent(
                    withParent(
                        withParent(
                            withParent(
                                allOf(
                                    withId(android.R.id.content),
                                    withParent(withId(com.google.android.material.R.id.action_bar_root))
                                )
                            )
                        )
                    )
                ),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("Please enter your name.")))

    }
}
