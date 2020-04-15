package org.wikipedia.suggestededits

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import org.wikipedia.R
import org.wikipedia.activity.BaseActivity
import org.wikipedia.util.ResourceUtil
import kotlinx.android.synthetic.main.activity_suggested_edits_tags_onboarding.*

class SuggestedEditsImageTagsOnboardingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColor(ResourceUtil.getThemedColor(this, R.attr.paper_color))
        setNavigationBarColor(ResourceUtil.getThemedColor(this, R.attr.paper_color))
        setContentView(R.layout.activity_suggested_edits_tags_onboarding)
        onboarding_done_button.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SuggestedEditsImageTagsOnboardingActivity::class.java)
        }
    }
}
