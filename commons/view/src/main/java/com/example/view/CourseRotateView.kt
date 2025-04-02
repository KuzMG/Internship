package com.example.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.extensions.dpToPx
import com.example.extensions.spToPx
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * TODO: document your custom view class.
 */
class CourseRotateView : View {

    private var _text: String? = null // TODO: use a default from R.string...
    private var _textColor: Int = Color.BLACK // TODO: use a default from R.color...
    private var _backgroundColorApp: Int = Color.BLACK // TODO: use a default from R.color...

    private var _rotate = 0 // TODO: use a default from R.dimen...

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


    var rotate: Int
        get() = _rotate
        set(value) {
            _rotate = value
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
            attrs, R.styleable.CourseRotateView, defStyle, 0
        )

        _text = a.getString(
            R.styleable.CourseRotateView_rtext
        )
        _textColor = a.getColor(
            R.styleable.CourseRotateView_rtextColor,
            textColor
        )
        _backgroundColorApp = a.getColor(
            R.styleable.CourseRotateView_rbackgroundColor,
            backgroundColorApp
        )
        _rotate = a.getInt(
            R.styleable.CourseRotateView_rrotate,
            rotate
        )

//        if (a.hasValue(R.styleable.CourseGreenView_exampleDrawable)) {
//            exampleDrawable = a.getDrawable(
//                R.styleable.CourseGreenView_exampleDrawable
//            )
//            exampleDrawable?.callback = this
//        }

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

    private var w: Int = 0
    private var h: Int = 0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        w = (paddingHorizontal * 2 + textWidth).toInt()
        h = (paddingVertical * 2 + textHeight).toInt()
        val rad = Math.toRadians(rotate.toDouble())
        val x1 = abs(cos(rad) * w)
        val x2 = abs(sin(rad) * h)
        val y1 = abs(sin(rad) * w)
        val y2 = abs(cos(rad) * h)
        setMeasuredDimension(
            (x1 + x2).toInt(),
            (y1 + y2).toInt()
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val rectF = RectF(
            0F,
            0F,
            w.toFloat(),
            h.toFloat()
        )
        val centerX = width / 2f
        val centerY = height / 2f

        canvas.translate(centerX, centerY)
        canvas.rotate(rotate.toFloat());
        canvas.translate(-w / 2f, -h / 2f)

        canvas.drawRoundRect(rectF, roundCorner, roundCorner, backgroundPaint);
        canvas.drawText(
            text ?: "",
            rectF.centerX(),
            rectF.centerY() + textHeight,
            textPaint
        )
    }
}