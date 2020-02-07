package com.cep96.padc_x_travel_cep.data.vos

import com.google.gson.annotations.SerializedName

data class ScoreAndReview (

    @SerializedName("name") val name: String,
    @SerializedName("score")val score: Double,
    @SerializedName("max_score")val maxScore: Int,
    @SerializedName("total_reviews")val totalReviews: Int
)