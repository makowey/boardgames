<script>
    import '@vismaux/nordic-cool/dist/css/nc.min.css';

    import Router from 'svelte-spa-router'
    import {routes} from './routes/routes'
    import {fade, fly} from 'svelte/transition';

    export let appName;
    export let version;
    let footerVisible = true;
    setTimeout(() => footerVisible = false, 1500);
</script>

<style>
    main {
        padding: 1em;
        max-width: 240px;
        margin: 0 auto;
    }

    @media (min-width: 640px) {
        main {
            max-width: none;
        }
    }

    footer {
        position: absolute;
        right: 30%;
        left: 30%;
        bottom: 0;
    }
</style>

<svelte:head>
    <html lang="en"></html>
    <title>{appName} - {version}</title>
    <meta name="robots" content="noindex nofollow"/>
</svelte:head>

<main>
    <div class="margin-top-10">
        <Router {routes}/>
    </div>
</main>

{#if footerVisible}
    <footer>
        <div class="alert alert-warning" role="alert" in:fly="{{ y: 200, duration: 2000 }}" out:fade={{duration: 5000}}>
            <strong>Warning!</strong> Application is under construction! :)
        </div>
    </footer>
{/if}
