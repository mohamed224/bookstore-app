CREATE TABLE `category` (
                            `id` bigint(20) NOT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            `pic_byte` tinyblob DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `category`
--
ALTER TABLE `category`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `category`
--
ALTER TABLE `category`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;
