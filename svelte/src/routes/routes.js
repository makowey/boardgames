import NotFound from './NotFound.svelte'
import Home from '../Home.svelte'

export const routes = {
    // Exact path
    '/': Home,
    '/home': Home,

    // Using named parameters, with last being optional
    //'/author/:first/:last?': Author,
    // Wildcard parameter
    //'/book/*': Book,

    // Catch-all
    // This is optional, but if present it must be the last
    '*': NotFound,
}