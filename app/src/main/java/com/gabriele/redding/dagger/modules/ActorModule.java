package com.gabriele.redding.dagger.modules;

import android.content.Context;

import com.gabriele.actor.internals.ActorRef;
import com.gabriele.actor.internals.ActorSystem;
import com.gabriele.redding.reddit.RedditActor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActorModule {

    @Provides
    @Singleton
    ActorSystem providesActorSystem(Context context) {
        return new ActorSystem(context);
    }

    @Provides
    @Singleton
    @Named("RedditActor")
    ActorRef providesRedditActor(ActorSystem system) {
        return system.actorOf(RedditActor.class);
    }

}
