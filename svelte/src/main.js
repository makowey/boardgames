import Main from './Main.svelte';

const app = new Main({
    target: document.body,
    props: {
        appName: 'Boardgames.com.ro - Biblioteca de jocuri',
        version: '2021.1.00-SNAPSHOT'
    }
});

export default app;