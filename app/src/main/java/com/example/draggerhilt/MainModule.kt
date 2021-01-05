package com.example.draggerhilt

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named
import javax.inject.Singleton

@Module  // module are container for dependencies that live specific amount of time. e.g., database instance, retrofit instance etc.
@InstallIn( // this is basically the scope for the module
//    ApplicationComponent::class  // this tell that the module live as long as application
    ActivityComponent::class // -> tell that the module live as long as the specific activity lives
//    FragmentComponent::class
//    ViewComponent::class -> to inject into a custom view
)
object MainModule {

    // here we want to give blueprint that how it can construct the dependencies that we want to inject

//    @Singleton // to create only single instance of the object, may be database or retrofit etc.
//    @Provides // tell dagger hilt to provide this function
//    fun provideTestString1() = "This is string1 we will inject"

    @ActivityScoped // Singleton is not used as it as long as activity
    @Provides
    @Named("String2") // named annotation help to solve which fun we need
    fun provideTestString2(
        @ApplicationContext context: Context,
        @Named("String1") testString1 : String
    ) = "${context.getString(R.string.inject_string)} - $testString1"

}