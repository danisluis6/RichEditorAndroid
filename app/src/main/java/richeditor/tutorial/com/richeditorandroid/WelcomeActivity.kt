package richeditor.tutorial.com.richeditorandroid

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import jp.wasabeef.richeditor.RichEditor
import android.widget.TextView


class WelcomeActivity : AppCompatActivity() {

    private var mPreview: TextView? = null
    private var mEditor: RichEditor? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        mEditor = findViewById(R.id.editor)

        mEditor!!.setEditorHeight(200)
        mEditor!!.setEditorFontSize(22)
        mEditor!!.setEditorFontColor(Color.RED)
        mEditor!!.setPadding(10, 10, 10, 10)
        mEditor!!.setPlaceholder("Insert text here...")

        mPreview = findViewById(R.id.preview)
        mEditor!!.setOnTextChangeListener { text -> mPreview!!.text = text }

        findViewById<ImageButton>(R.id.action_undo).setOnClickListener { mEditor!!.undo() }

        findViewById<ImageButton>(R.id.action_redo).setOnClickListener { mEditor!!.redo() }

        findViewById<ImageButton>(R.id.action_bold).setOnClickListener { mEditor!!.setBold() }

        findViewById<ImageButton>(R.id.action_italic).setOnClickListener { mEditor!!.setItalic() }

        findViewById<ImageButton>(R.id.action_subscript).setOnClickListener { mEditor!!.setSubscript() }

        findViewById<ImageButton>(R.id.action_superscript).setOnClickListener { mEditor!!.setSuperscript() }

        findViewById<ImageButton>(R.id.action_strikethrough).setOnClickListener { mEditor!!.setStrikeThrough() }

        findViewById<ImageButton>(R.id.action_underline).setOnClickListener { mEditor!!.setUnderline() }

        findViewById<ImageButton>(R.id.action_heading1).setOnClickListener { mEditor!!.setHeading(1) }

        findViewById<ImageButton>(R.id.action_heading2).setOnClickListener { mEditor!!.setHeading(2) }

        findViewById<ImageButton>(R.id.action_heading3).setOnClickListener { mEditor!!.setHeading(3) }

        findViewById<ImageButton>(R.id.action_heading4).setOnClickListener { mEditor!!.setHeading(4) }

        findViewById<ImageButton>(R.id.action_heading5).setOnClickListener { mEditor!!.setHeading(5) }

        findViewById<ImageButton>(R.id.action_heading6).setOnClickListener { mEditor!!.setHeading(6) }

        var isChangedTxtColor = false
        findViewById<ImageButton>(R.id.action_txt_color).setOnClickListener {
            mEditor!!.setTextColor(if (isChangedTxtColor) Color.BLACK else Color.RED)
            isChangedTxtColor = !isChangedTxtColor
        }

        var isChangedReverseTxtColor = false
        findViewById<ImageButton>(R.id.action_txt_color).setOnClickListener {
            mEditor!!.setTextBackgroundColor(if (isChangedReverseTxtColor) Color.TRANSPARENT else Color.YELLOW)
            isChangedReverseTxtColor = !isChangedReverseTxtColor
        }

        findViewById<ImageButton>(R.id.action_indent).setOnClickListener { mEditor!!.setIndent() }

        findViewById<ImageButton>(R.id.action_outdent).setOnClickListener { mEditor!!.setOutdent() }

        findViewById<ImageButton>(R.id.action_align_left).setOnClickListener { mEditor!!.setAlignLeft() }

        findViewById<ImageButton>(R.id.action_align_center).setOnClickListener { mEditor!!.setAlignCenter() }

        findViewById<ImageButton>(R.id.action_align_right).setOnClickListener { mEditor!!.setAlignRight() }

        findViewById<ImageButton>(R.id.action_blockquote).setOnClickListener { mEditor!!.setBlockquote() }

        findViewById<ImageButton>(R.id.action_insert_bullets).setOnClickListener { mEditor!!.setBullets() }

        findViewById<ImageButton>(R.id.action_insert_numbers).setOnClickListener { mEditor!!.setNumbers() }

        findViewById<ImageButton>(R.id.action_insert_image).setOnClickListener {
            mEditor!!.insertImage("http://www.1honeywan.com/dachshund/image/7.21/7.21_3_thumb.JPG",
                    "dachshund")
        }

        findViewById<ImageButton>(R.id.action_insert_link).setOnClickListener {
            mEditor!!.insertLink("https://github.com/wasabeef", "wasabeef")
        }

        findViewById<ImageButton>(R.id.action_insert_checkbox).setOnClickListener {
            mEditor!!.insertTodo()
        }
    }
}
