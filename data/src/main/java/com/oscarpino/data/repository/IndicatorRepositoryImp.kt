package com.oscarpino.repository

import com.oscarpino.common.base.BaseResponse
import com.oscarpino.common.base.BaseResult
import com.oscarpino.data.data.IndicatorApi
import com.oscarpino.domain.model.Indicator
import com.oscarpino.domain.repository.IndicatorRepository
import com.oscarpino.domain.model.Indicators
import com.oscarpino.mapper.toIndicatorDomain

class IndicatorRepositoryImp(private val api: IndicatorApi): IndicatorRepository {

    override suspend fun getIndicators(): BaseResponse<Indicators> {

        return try {

            val response = api.getAllIndicators()

            response.body()?.let {

                indicators ->

                BaseResponse(
                    payload=Indicators(
                    version = indicators.version,
                    autor = indicators.autor,
                    date = indicators.date,
                    uf = indicators.uf.toIndicatorDomain(),
                    ivp = indicators.ivp.toIndicatorDomain(),
                    dolar = indicators.dolar.toIndicatorDomain(),
                    dollarExchange = indicators.dollarExchange.toIndicatorDomain(),
                    euro = indicators.euro.toIndicatorDomain(),
                    ipc = indicators.ipc.toIndicatorDomain(),
                    utm = indicators.utm.toIndicatorDomain(),
                    imacec = indicators.imacec.toIndicatorDomain(),
                    tpm = indicators.tpm.toIndicatorDomain(),
                    copperPound = indicators.copperPound.toIndicatorDomain(),
                    unemploymentMug = indicators.unemploymentMug.toIndicatorDomain(),
                    bitcoin = indicators.bitcoin.toIndicatorDomain()
                                        ), result= BaseResult.SUCCESSFUL)
            }?:run{
                BaseResponse(result = BaseResult.ERROR, payload = null)
            }

        } catch (e: Exception) {
            BaseResponse(result = BaseResult.ERROR, payload = null)
        }
    }

    override suspend fun getIndicatorByName(name: String): BaseResponse<Indicator> {

        return try {

            api.getIndicatorByName(name).body()?.let {

                indicator ->

                BaseResponse(
                    payload = Indicator(
                        code = indicator.code,
                        name = indicator.name,
                        unitOfMeasure = indicator.unitOfMeasure,
                        date = indicator.date?:"",
                        value = indicator.value?:0.0,
                        serie = indicator.toIndicatorDomain().serie
                    ),
                    result = BaseResult.SUCCESSFUL
                )

            } ?: BaseResponse(
                result = BaseResult.ERROR,
                payload = null
            )

        } catch (e: Exception) {
            val e = e.message
            BaseResponse(
                result = BaseResult.ERROR,
                payload = null
            )
        }
    }

    override suspend fun getIndicatorByNameAndDate(
        name: String,
        date: String
    ): BaseResponse<Indicator> {
        TODO("Not yet implemented")
    }

    override suspend fun getIndicatorByNameAndYear(
        name: String,
        year: String
    ): BaseResponse<Indicator> {
        TODO("Not yet implemented")
    }
}
