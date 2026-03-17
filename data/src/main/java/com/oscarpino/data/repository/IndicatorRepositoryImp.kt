package com.oscarpino.repository

import com.oscarpino.common.base.BaseResponse
import com.oscarpino.common.base.BaseResult
import com.oscarpino.data.data.IndicatorApi
import repository.IndicatorRepository
import com.oscarpino.domain.model.Indicators
import com.oscarpino.mapper.toIndicatorDomain

class IndicatorRepositoryImp(private val api: IndicatorApi): IndicatorRepository {

    override suspend fun getIndicators(): BaseResponse<Indicators> {

        return try {

            val response = api.getAllIndicators()

            response.body()?.let {

                val indicators = Indicators(

                    version = it.version,
                    autor = it.autor,
                    date = it.date,
                    uf = it.uf.toIndicatorDomain(),
                    ivp = it.ivp.toIndicatorDomain(),
                    dolar = it.dolar.toIndicatorDomain(),
                    dollarExchange = it.dollarExchange.toIndicatorDomain(),
                    euro = it.euro.toIndicatorDomain(),
                    ipc = it.ipc.toIndicatorDomain(),
                    utm = it.utm.toIndicatorDomain(),
                    imacec = it.imacec.toIndicatorDomain(),
                    tpm = it.tpm.toIndicatorDomain(),
                    copperPound = it.copperPound.toIndicatorDomain(),
                    unemploymentMug = it.unemploymentMug.toIndicatorDomain(),
                    bitcoin = it.bitcoin.toIndicatorDomain()
                )

                BaseResponse(result = BaseResult.SUCCESSFUL, payload = indicators)

            }?:run{
                BaseResponse(result = BaseResult.ERROR, payload = null)
            }

        } catch (e: Exception) {
            BaseResponse(result = BaseResult.ERROR, payload = null)
        }
    }
}