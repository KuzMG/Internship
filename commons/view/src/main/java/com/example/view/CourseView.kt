package com.example.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.example.extensions.dpToPx
import com.example.extensions.spToPx
import com.example.view.model.Course
import com.example.view.model.LineCourses

/**
 * TODO: document your custom view class.
 */
class CourseView : View {


    private var _text: String? = null // TODO: use a default from R.string...
    private var _textColor: Int = Color.BLACK // TODO: use a default from R.color...
    private var _backgroundColorApp: Int = Color.BLACK // TODO: use a default from R.color...


    private lateinit var textPaint: TextPaint
    private lateinit var backgroundPaint: Paint
    private var textWidth: Float = 0f
    private var textHeight: Float = 0f


    var text: String?
        get() = _text
        set(value) {
            _text = value
            invalidateTextPaintAndMeasurements()
        }

    var textColor: Int
        get() = _textColor
        set(value) {
            _textColor = value
            invalidateTextPaintAndMeasurements()
        }

    var backgroundColorApp: Int
        get() = _backgroundColorApp
        set(value) {
            _backgroundColorApp = value
            invalidateTextPaintAndMeasurements()
        }

    private val paddingHorizontal = 24f.dpToPx(context)
    private val paddingVertical = 20f.dpToPx(context)
    private var exampleTextSize = 14f.spToPx(context)
    private val roundCorner = 100f.dpToPx(context)

    var exampleDrawable: Drawable? = null

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.CourseView, defStyle, 0
        )

        _text = a.getString(
            R.styleable.CourseView_text
        )
        _textColor = a.getColor(
            R.styleable.CourseView_textColor,
            textColor
        )
        _backgroundColorApp = a.getColor(
            R.styleable.CourseView_backgroundColor,
            backgroundColorApp
        )

        a.recycle()

        textPaint = TextPaint().apply {
            flags = Paint.ANTI_ALIAS_FLAG
            textAlign = Paint.Align.CENTER
        }
        backgroundPaint = Paint().apply {
            flags = Paint.ANTI_ALIAS_FLAG
        }
        invalidateTextPaintAndMeasurements()
    }

    private fun invalidateTextPaintAndMeasurements() {
        textPaint.let {
            it.textSize = exampleTextSize
            it.color = textColor
            textWidth = it.measureText(text)
            textHeight = it.fontMetrics.bottom
        }
        backgroundPaint.let {
            it.color = backgroundColorApp
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(
            (paddingHorizontal * 2 + textWidth).toInt(),
            (paddingVertical * 2 + textHeight).toInt()
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val rectF = RectF(
            0F,
            0F,
            measuredWidth.toFloat(),
            measuredHeight.toFloat()
        )
        canvas.drawRoundRect(rectF, roundCorner, roundCorner, backgroundPaint);
        canvas.drawText(
            text?: "",
            rectF.centerX(),
            rectF.centerY() + textHeight,
            textPaint
        )
    }
}