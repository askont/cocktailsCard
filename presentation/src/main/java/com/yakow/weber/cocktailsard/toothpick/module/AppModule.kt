package com.yakow.weber.cocktailsard.toothpick.module

import android.content.Context
import com.yakow.weber.cocktailsard.toothpick.system.ResourceManager
import com.yakow.weber.cocktailsard.toothpick.system.message.SystemMessageNotifier
import com.yakow.weber.data.prefs.AppPrefs
import com.yakow.weber.data.prefs.PrefsProvider
import com.yakow.weber.data.repository.MainRepository
import com.yakow.weber.data.system.executor.AppExecutors
import com.yakow.weber.data.system.executor.ExecutorsProvider
import com.yakow.weber.data.system.schedulers.AppSchedulers
import com.yakow.weber.data.system.schedulers.SchedulersProvider
import com.yakow.weber.domain.interactor.MainInteractor
import com.yakow.weber.domain.interactor.contract.MainContract
import timber.log.Timber
import toothpick.config.Module

/**
 * Created on 05.02.19
 * @author YWeber */

class AppModule(context: Context) : Module() {
    init {
        Timber.d("init app module")
        bind(Context::class.java).toInstance(context)
        bind(ResourceManager::class.java).toInstance(ResourceManager(context))
        bind(SchedulersProvider::class.java).toInstance(AppSchedulers())
        bind(ExecutorsProvider::class.java).toInstance(AppExecutors())
        bind(SystemMessageNotifier::class.java).toInstance(SystemMessageNotifier())
        bind(PrefsProvider::class.java).to(AppPrefs::class.java).singletonInScope()
        // main
        bind(MainContract::class.java).to(MainRepository::class.java)
        bind(MainInteractor::class.java).to(MainInteractor::class.java)
    }
}